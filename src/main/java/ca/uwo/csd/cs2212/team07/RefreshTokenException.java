package ca.uwo.csd.cs2212.team07;

/**
 * RefreshTokenException class, thrown when there is an error in the RefreshTokens.java
 * @author Team07
 */
public class RefreshTokenException extends Exception {

    /**
     * Constructor method: creates RefreshTokenException object
     * @param message the message generated
     */
    public RefreshTokenException(String message) {
        super(message);
    }
    
    /**
     * Constructor method: creates RefreshTokenException object
     */
    public RefreshTokenException(){
        this("RefreshTokenException");
    }
}
