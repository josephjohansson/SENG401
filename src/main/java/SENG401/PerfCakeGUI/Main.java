package SENG401.PerfCakeGUI;

import org.perfcake.ScenarioExecution;

public class Main {
	
	final static String[] newArgs = new String[]
    		{
    				"-s", "http.xml",
    				"-sdD:\\workspace\\PerfCakeGUI\\resources\\scenarios\\http.xml",
    				"-Dserver.host=httpbin.org",
    				"-Dthis=that"
    		};
	
    public static void main(String[] args)
    {	
    	
    	ScenarioExecution.main(newArgs);
    }
    
}
