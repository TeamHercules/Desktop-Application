package ca.uwo.csd.cs2212.team07;

import com.github.scribejava.core.model.*;

public class testapi{
	
	
	public static void main(String[] args)
	{
		Api test = new Api();
		
		Response bestDays = test.getBestDays();
                
                System.out.println("BEST DAYS: " +bestDays.getBody());
		
	}
	
}
