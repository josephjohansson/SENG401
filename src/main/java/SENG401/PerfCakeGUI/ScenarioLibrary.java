package SENG401.PerfCakeGUI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScenarioLibrary {
	
	private static ScenarioLibrary instance = new ScenarioLibrary();
	private static final String[] fileExtensions = {".xml"};
	private static Map<String, String> files = new HashMap<String, String>();
	
	private ScenarioLibrary() {
	}
	
	/**
	 * Get the ScenarioLibrary instance
	 * @return
	 */
	public static ScenarioLibrary getInstance() { return instance; }

	/**
	 * Attempt to add scenario files to the library
	 * 
	 * @param path
	 * @param recursively Go through the folders recursively
	 * @return Number of files added
	 */
	public int searchForScenarios(String path, boolean recursively) {
		if(path == null)
			return 0;
		File dir = new File(path);
		return searchForScenarios(dir, recursively);
	}
	
	/**
	 * Attempt to add scenario files to the library
	 * 
	 * @param dir
	 * @param recursively Go through the folders recursively
	 * @return Number of files added
	 */
	public int searchForScenarios(File dir, boolean recursively) {
		if(dir == null)
			return 0;

		if(!dir.isDirectory() || dir.isFile() || !dir.exists())
			return 0;

		// Is a directory that exists
		try {
			return loadFromDirectory(dir, recursively);
		} catch (IOException e) {
			// Do nothing
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets the keySet of all available scenarios
	 * 
	 * @return Available scenarios
	 */
	public Set<String> getAvailableScenarios() {
		return files.keySet();
	}
	
	/**
	 * Gets the path to the given scenario file.
	 * 
	 * @param scenarioName
	 * @return Null if not found; the scenario path otherwise
	 */
	public String getPathForScenarioName(String scenarioName) {
		if(files.containsKey(scenarioName))
			return files.get(scenarioName);
		else
			return null;
	}
	
	/**
	 * Loads files from the given directory
	 * 
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	private static int loadFromDirectory(File dir, boolean recursively) throws IOException {
		int count = 0;
		for(String name : dir.list()) {
			File file = new File(dir.getCanonicalPath() + File.separatorChar + name);
				if(file.isDirectory()) {
					if(recursively)
						count += loadFromDirectory(file, true);
				} else if(file.isFile()) {
					for(String extension : fileExtensions)
						if(name.endsWith(extension)) {
							if(!files.containsValue(file.getAbsolutePath())) {
								files.put(name.toLowerCase(), file.getAbsolutePath().replace("\\", "\\\\"));
								count++;
								break;
							}
						}
				}
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Files found: " + ScenarioLibrary.getInstance().searchForScenarios("D:\\workspace\\PerfCakeGUI\\resources", true));
		System.out.println(files.size());
		for(String name : instance.getAvailableScenarios()) {
			System.out.println(name + '\t' + instance.getPathForScenarioName(name));
		}
	}
	
}
