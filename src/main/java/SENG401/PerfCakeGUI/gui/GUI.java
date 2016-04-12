package SENG401.PerfCakeGUI.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import SENG401.PerfCakeGUI.PerfCakeStarter;
import SENG401.PerfCakeGUI.ScenarioLibrary;
import SENG401.PerfCakeGUI.ScenarioProperty;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class GUI {

	private JFrame frame;
	private JTextField FolderInputField;
	private JTextField PropertyNameField;
	private JTextField PropertyValueField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {400, 400};
		gridBagLayout.rowHeights = new int[]{411, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 0};
		gbl_panel.rowHeights = new int[] {0, 30, 0, 0, 30};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		FolderInputField = new JTextField();
		GridBagConstraints gbc_FolderInputField = new GridBagConstraints();
		gbc_FolderInputField.gridwidth = 2;
		gbc_FolderInputField.insets = new Insets(0, 0, 5, 5);
		gbc_FolderInputField.fill = GridBagConstraints.HORIZONTAL;
		gbc_FolderInputField.gridx = 0;
		gbc_FolderInputField.gridy = 0;
		panel.add(FolderInputField, gbc_FolderInputField);
		FolderInputField.setColumns(10);
		
		JButton ScanButton = new JButton("Scan For Scenarios");
		ScanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path = FolderInputField.getText();
					System.out.print("Searching for scenarios in '" + path + "'...");
					System.out.print(" found " + ScenarioLibrary.getInstance().searchForScenarios(path, false) + " scenarios.\n");
					ScenarioSelectionBox.updateBox();
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		GridBagConstraints gbc_ScanButton = new GridBagConstraints();
		gbc_ScanButton.insets = new Insets(0, 0, 5, 0);
		gbc_ScanButton.gridx = 2;
		gbc_ScanButton.gridy = 0;
		panel.add(ScanButton, gbc_ScanButton);
		
		final JComboBox<String> ScenarioBox = new JComboBox<String>();
		ScenarioSelectionBox.setBox(ScenarioBox);
		GridBagConstraints gbc_ScenarioBox = new GridBagConstraints();
		gbc_ScenarioBox.gridwidth = 3;
		gbc_ScenarioBox.insets = new Insets(0, 0, 5, 5);
		gbc_ScenarioBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_ScenarioBox.gridx = 0;
		gbc_ScenarioBox.gridy = 1;
		panel.add(ScenarioBox, gbc_ScenarioBox);
		
		PropertyNameField = new JTextField();
		GridBagConstraints gbc_PropertyNameField = new GridBagConstraints();
		gbc_PropertyNameField.insets = new Insets(0, 0, 5, 5);
		gbc_PropertyNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PropertyNameField.gridx = 0;
		gbc_PropertyNameField.gridy = 2;
		panel.add(PropertyNameField, gbc_PropertyNameField);
		PropertyNameField.setColumns(10);
		
		JLabel lblPropertyName = new JLabel("Property Name");
		GridBagConstraints gbc_lblPropertyName = new GridBagConstraints();
		gbc_lblPropertyName.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropertyName.gridx = 1;
		gbc_lblPropertyName.gridy = 2;
		panel.add(lblPropertyName, gbc_lblPropertyName);
		
		PropertyValueField = new JTextField();
		GridBagConstraints gbc_PropertyValueField = new GridBagConstraints();
		gbc_PropertyValueField.insets = new Insets(0, 0, 5, 5);
		gbc_PropertyValueField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PropertyValueField.gridx = 0;
		gbc_PropertyValueField.gridy = 3;
		panel.add(PropertyValueField, gbc_PropertyValueField);
		PropertyValueField.setColumns(10);
		
		JLabel lblPropertyValue = new JLabel("Property Value");
		GridBagConstraints gbc_lblPropertyValue = new GridBagConstraints();
		gbc_lblPropertyValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropertyValue.gridx = 1;
		gbc_lblPropertyValue.gridy = 3;
		panel.add(lblPropertyValue, gbc_lblPropertyValue);
		
		JButton AddPropertyButton = new JButton("Add Property");
		AddPropertyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pName = PropertyNameField.getText();
				String pVal = PropertyValueField.getText();
				ScenarioProperty prop = new ScenarioProperty(pName, pVal);
				ScenarioPropertiesController.addProperty(prop);
			}
		});
		GridBagConstraints gbc_AddPropertyButton = new GridBagConstraints();
		gbc_AddPropertyButton.insets = new Insets(0, 0, 5, 0);
		gbc_AddPropertyButton.gridx = 2;
		gbc_AddPropertyButton.gridy = 3;
		panel.add(AddPropertyButton, gbc_AddPropertyButton);
		
		final JList<ScenarioProperty> list = new JList<ScenarioProperty>();
		ScenarioPropertiesController.setPropertyJList(list);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 0);
		gbc_list.gridwidth = 3;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 4;
		panel.add(list, gbc_list);
		
		JButton DeletePropertyButton = new JButton("Delete Property");
		DeletePropertyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScenarioProperty prop = list.getSelectedValue();
				ScenarioPropertiesController.removeProperty(prop);
			}
		});
		GridBagConstraints gbc_DeletePropertyButton = new GridBagConstraints();
		gbc_DeletePropertyButton.insets = new Insets(0, 0, 5, 0);
		gbc_DeletePropertyButton.gridx = 2;
		gbc_DeletePropertyButton.gridy = 5;
		panel.add(DeletePropertyButton, gbc_DeletePropertyButton);
		
		JButton StartTestButton = new JButton("Start Test");
		StartTestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfCakeStarter starter = new PerfCakeStarter((String) ScenarioBox.getSelectedItem(), ScenarioLibrary.getInstance().getPathForScenarioName((String) ScenarioBox.getSelectedItem()));
				starter.addAllProperties(ScenarioPropertiesController.getProperties());
				starter.start();
			}
		});
		GridBagConstraints gbc_StartTestButton = new GridBagConstraints();
		gbc_StartTestButton.insets = new Insets(0, 0, 0, 5);
		gbc_StartTestButton.gridwidth = 2;
		gbc_StartTestButton.gridx = 0;
		gbc_StartTestButton.gridy = 6;
		panel.add(StartTestButton, gbc_StartTestButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JTextArea ConsoleBox = new JTextArea();
		ConsoleBoxController.setBox(ConsoleBox);
		ConsoleBox.setLineWrap(true);
		scrollPane.setViewportView(ConsoleBox);
	}

}
