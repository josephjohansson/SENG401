package SENG401.PerfCakeGUI;

/**
 * Used to represent the scenario property that will be
 * used in the generation of the arguments used to start
 * PerfCake
 * @author Tanner Hagel
 *
 */
public class ScenarioProperty {

	public ScenarioProperty() {
	}
	
	public ScenarioProperty(String name, String value) {
		this.propertyName = name;
		this.propertyValue = value;
	}
	
	/**
	 * The property name (for example, in
	 * -Dserver.host=www.google.ca the name is 'server.host'
	 */
	private String propertyName;
	
	/**
	 * The property value (for example, in
	 * -Dserver.host=www.google.ca the value is 'www.google.ca'
	 */
	private String propertyValue;
	
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getPropertyValue() {
		return propertyValue;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
}
