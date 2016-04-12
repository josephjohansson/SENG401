package SENG401.PerfCakeGUI;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.perfcake.ScenarioExecution;

/**
 * Used to start up PerfCake. Works similar to a builder. Give
 * it properties, the file path, set the output stream, and start it up!
 * 
 * @author Tanner Hagel
 *
 */
public class PerfCakeStarter {

	private String fileName;
	private String filePath;
	private List<ScenarioProperty> properties = new ArrayList<ScenarioProperty>();
	private PrintStream printStream = null;
	private PrintStream errPrintStream = null;
	private Thread thread;
	
	public PerfCakeStarter(String name, String path) {
		this.fileName = name;
		this.filePath = path;
	}
	
	public void setStandardPrintStream(PrintStream stream) {
		this.printStream = stream;
	}
	
	public void setErrorPrintStream(PrintStream stream) {
		this.errPrintStream = stream;
	}
	
	public void addProperty(ScenarioProperty prop) {
		properties.add(prop);
	}
	
	public void addAllProperties(Collection<ScenarioProperty> props) {
		properties.addAll(props);
	}
	
	public void removeProperty(ScenarioProperty prop) {
		properties.remove(prop);
	}
	
	
	/**
	 * Starts up PerfCake on a new thread.
	 */
	public void start() {
		if(this.thread == null) {
			thread = new Thread(new Runnable() {
				public void run() {
					RunPerfCake();
				}
			});
			thread.start();
		} else {
			// Should we do something about this?
		}
	}
	
	public void stop() {
		if(this.thread != null) {
			this.thread.stop();
		}
	}
	
	
	private void RunPerfCake() {
		if(printStream != null)
			System.setOut(printStream);
		if(errPrintStream != null)
			System.setErr(errPrintStream);
		
		List<String> args = new ArrayList<String>();
		args.add("-s");
		args.add(fileName);
		args.add("-sd" + filePath);
		for(ScenarioProperty prop : this.properties) {
			args.add("-D" + prop.getPropertyName() + "=" + prop.getPropertyValue());
		}
		
		String[] newArgs = new String[args.size()];
		for(int i = 0; i < newArgs.length; i++) {
			newArgs[i] = args.get(i);
		}
		
		ScenarioExecution.main(newArgs);
	}
}
