package SENG401.PerfCakeGUI.gui;

import javax.swing.JComboBox;

import SENG401.PerfCakeGUI.ScenarioLibrary;

public class ScenarioSelectionBox {
	
	private static JComboBox box;
	
	public static void setBox(JComboBox pbox) { box = pbox; updateBox(); }
	public static JComboBox getBox() { return box; }
	public static void updateBox() {
		box.removeAllItems();
		for(String scen : ScenarioLibrary.getInstance().getAvailableScenarios())
			box.addItem(scen);
		
	}
	

}
