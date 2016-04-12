package SENG401.PerfCakeGUI.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

import SENG401.PerfCakeGUI.ScenarioProperty;

public class ScenarioPropertiesController {
	private static ScenarioPropertiesController instance = new ScenarioPropertiesController();
	private ScenarioPropertiesController() {
	}
	
	private static JList<ScenarioProperty> propsList;
	public static void setPropertyJList(JList<ScenarioProperty> list) { propsList = list; }
	
	private List<ScenarioProperty> list = new ArrayList<ScenarioProperty>();
	
	public void updateList() {
		DefaultListModel<ScenarioProperty> model = new DefaultListModel<ScenarioProperty>();
		for(ScenarioProperty prop : list) {
			model.addElement(prop);
		}
		propsList.setModel(model);
	}
	
	public static void addProperty(ScenarioProperty prop) {
		instance.list.add(prop);
		instance.updateList();
	}
	
	public static void removeProperty(ScenarioProperty prop) {
		instance.list.remove(prop);
		instance.updateList();
	}
	
	public static List<ScenarioProperty> getProperties() {
		return new ArrayList<ScenarioProperty>(instance.list);
	}
	

}
