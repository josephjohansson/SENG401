package SENG401.PerfCakeGUI;

import org.perfcake.ScenarioExecution;

public class Main {
	
	final static String[] newArgs = new String[]
    		{
    				"-s", "http",
    				"-sdD:\\workspace\\PerfCakeGUI",
    				"-Dserver.host=httpbin.org"
    		};
	
    public static void main(String[] args)
    {	
    	
    	ScenarioExecution.main(newArgs);
    }
    
}
