package SENG401.PerfCakeGUI;

import org.perfcake.ScenarioExecution;

public class App {
	
	final static String[] newArgs = new String[]
    		{
    				"-s", "http",
    				"-sdD:\\workspace\\PerfCakeGUI",
    				"-Dserver.host=httpbin.org"
    		};
	public static java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
	
    public static void main(String[] args)
    {	
        System.setOut(new java.io.PrintStream(out));
    	new Thread(new Runner()).start();
    	
    	ScenarioExecution.main(newArgs);
    }
    
    private static class Runner implements Runnable {
    	public Runner() {}

		public void run() {
			try {
				synchronized(Runner.class) {
					int i = 0;
					while(i < 10) {
						Runner.class.wait(500);
						System.err.println("Runner:" + out);
						i++;
					}
				}
			} catch (InterruptedException e) {
				
			}
			
		} 	
    	
    }
    
}
