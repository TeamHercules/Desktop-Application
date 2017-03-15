package ca.uwo.csd.cs2212.team07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.github.scribejava.apis.FitbitApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuthService;
import com.github.scribejava.core.model.*; //Request Verb
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.apis.service.FitbitOAuth20ServiceImpl;


/**

 *  This class is used to refresh tokens and make API calls
 * @author Team07
 */
public class RefreshTokens {

   // Static instance variables
    private static String CALL_BACK_URI = "http://localhost:8080";
    private static int CALL_BACK_PORT = 8080;

    /**
     * getResponse() method, used to make an API request and returns the response from Fitbit
     * @param requestUrl url specifying the api request to make
     * @return Response object containing JSON object with information from Fitbit
     * @throws RefreshTokenException  if there is a problem refreshing (status code != 200)
     */
    public static Response getResponse(String requestUrl) throws RefreshTokenException {

        //read credentials from a file
        BufferedReader bufferedReader = null;
        // This will reference one line at a time
        String line = null;

        //Need to save service credentials for Fitbit
        String apiKey = null;
        String apiSecret = null;
        String clientID = null;

        //holder for all the elements we will need to make an access token ( information about an authenticated session )
        String accessTokenItself = null;
        String tokenType = null;
        String refreshToken = null;
        Long expiresIn = null;
        String rawResponse = null;

        //This is the only scope you have access to currently
        String scope = "activity%20heartrate";
        try {
            // File with service credentials.

            FileReader fileReader
                    = new FileReader("src/main/resources/Team7Credentials.txt"); // location of credential file
            bufferedReader = new BufferedReader(fileReader);
            clientID = bufferedReader.readLine();
            apiKey = bufferedReader.readLine();
            apiSecret = bufferedReader.readLine();
            bufferedReader.close();
            fileReader = new FileReader("src/main/resources/Team7Tokens.txt"); // location of tokens file
            bufferedReader = new BufferedReader(fileReader);

            accessTokenItself = bufferedReader.readLine();
            tokenType = bufferedReader.readLine();
            refreshToken = bufferedReader.readLine();
            expiresIn = Long.parseLong(bufferedReader.readLine());
            rawResponse = bufferedReader.readLine();

        } catch (FileNotFoundException ex) { // error message if file cannot be opened
            System.out.println(
                    "Unable to open file\n" + ex.getMessage());
            System.exit(1);
        } catch (IOException ex) {  // error message if file cannot be written
            System.out.println( 
                    "Error reading/write file\n" + ex.getMessage());
            System.exit(1);
        } finally { // gets executed no matter what
            try {
                if (bufferedReader != null) // Always close files.
                {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                System.out.println(
                        "Error closing file\n" + e.getMessage());
            }
        }
        //  Create the Fitbit service - you will ask this to ask for access/refresh pairs
        //     and to add authorization information to the requests to the API
        FitbitOAuth20ServiceImpl service = (FitbitOAuth20ServiceImpl) new ServiceBuilder()
                .apiKey(clientID) //fitbit uses the clientID here
                .apiSecret(apiSecret)
                .callback("http://localhost:8080")
                .scope(scope)
                .grantType("authorization_code")
                .build(FitbitApi20.instance());

        //  The access token contains everything you will need to authenticate your requests
        //  It can expire - at which point you will use the refresh token to refresh it
        //  See: https://dev.fitbit.com/docs/oauth2/#refreshing-tokens
        //    I have authenticated and given you the contents of the response to use
        OAuth2AccessToken accessToken = new OAuth2AccessToken(
                accessTokenItself,
                tokenType,
                refreshToken,
                expiresIn,
                rawResponse);
        // Now let's go and ask for a protected resource!
        // This actually generates an HTTP request from the URL
        //    -it has a header, body ect.
        OAuthRequest request = new OAuthRequest(Verb.GET, requestUrl, service);

        // This adds the information required by Fitbit to add the authorization information to the HTTP request
        // You must do this before the request will work
        // See: https://dev.fitbit.com/docs/oauth2/#making-requests
        service.signRequest(accessToken, request);

        //  This actually sends the request:
        Response response = request.send();

        //  The HTTP response from fitbit will be in HTTP format, meaning that it has a numeric code indicating
        //     whether is was successful (200) or not (400's or 500's), each code has a different meaning
        int statusCode = response.getCode();

        switch (statusCode) {
            case 200:
                break;
            case 400:
                throw new RefreshTokenException("Bad Request");
            case 401:
                //Likely Expired token- TRY TO REFRESH

                // This uses the refresh token to get a completely new accessToken object
                //   See:  https://dev.fitbit.com/docs/oauth2/#refreshing-tokens           
                // This accessToken is now the current one, and the old ones will not work
                //   again.  You should save the contents of accessToken.
                try {
                    accessToken = service.refreshOAuth2AccessToken(accessToken); //THIS IS WHERE REFRESH TOKEN PROBLEM HAPPENS
                    writeToken(accessToken);
                }
                catch (RefreshTokenException e){
                    throw e;
                }
                catch (Exception e) {
                    throw new RefreshTokenException("Error refreshing token, expired token" + e.getMessage());
                }

                // Now we can try to access the service again
                // Make sure you create a new OAuthRequest object each time!
                request = new OAuthRequest(Verb.GET, requestUrl, service);
                service.signRequest(accessToken, request);
                response = request.send();

                // Hopefully got a response this time:
                break;
            case 429:
                System.out.println("Rate limit exceeded");
                throw new RefreshTokenException("429-Rate Limit Exceeded");
        }

        
        // if the response code was not 200, throw exception
        if (response.getCode() != 200) {
            throw new RefreshTokenException("Error Accessing API");
        } else { // else response is valid, return response
            return response;
        }
    }
    
    private static void writeToken(OAuth2AccessToken tokenToSave) throws RefreshTokenException{
         BufferedWriter bufferedWriter = null;
        //  Save the current accessToken information for next time

        // IF YOU DO NOT SAVE THE CURRENTLY ACTIVE TOKEN INFO YOU WILL NOT BE ABLE TO REFRESH
        //   - contact Beth if this happens and she can reissue you a fresh set
        try {
            FileWriter fileWriter;
            fileWriter
                    = new FileWriter("src/main/resources/Team7Tokens.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tokenToSave.getToken());
            bufferedWriter.newLine();
            bufferedWriter.write(tokenToSave.getTokenType());
            bufferedWriter.newLine();
            bufferedWriter.write(tokenToSave.getRefreshToken());
            bufferedWriter.newLine();
            bufferedWriter.write(tokenToSave.getExpiresIn().toString());
            bufferedWriter.newLine();
            bufferedWriter.write(tokenToSave.getRawResponse());
            bufferedWriter.newLine();
            bufferedWriter.close();
            System.out.println("TOKENS HAVE BEEN REWRITTEN- PLEASE DISTRUBUTE NEW TOKENS TO TEAM!!!!");
        } catch (FileNotFoundException ex) {
            throw new RefreshTokenException("Unable to open file\n" + ex.getMessage());
        } catch (IOException ex) {
             throw new RefreshTokenException("Unable to read/write file\n" + ex.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                System.out.println(
                        "Error closing file\n" + e.getMessage());
            }
        }//end try
       
    }

}
