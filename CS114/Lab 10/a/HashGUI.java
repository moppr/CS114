package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class HashGUI{

	public static void main(String[] args){
		JFrame frame = new JFrame("kevin said not to make it yellow so i didn't");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GUIPanel());
		frame.pack();
		frame.setVisible(true);		
	}
}

class GUIPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private FieldPanel field1, field2, field3, field4, search;
	private JLabel searchLabel, label1, label2, label3, label4;
	private JButton searchButton;

	private HashMap<String, String> hashTable = new HashMap<String, String>();

	public GUIPanel(){
		setBackground(Color.GREEN);
		
		field1 = new FieldPanel("Hash Key #1:", 25);
		field2 = new FieldPanel("Hash Key #2:", 25);
		field3 = new FieldPanel("Hash Key #3:", 25);
		field4 = new FieldPanel("Hash Key #4:", 25);

		search = new FieldPanel("Search for Key:", 25);

		searchLabel = new JLabel("");

		searchButton = new JButton("Hash Search");
		searchButton.addActionListener(new SearchListener());

		label1 = new JLabel("");
		label2 = new JLabel("");
		label3 = new JLabel("");
		label4 = new JLabel("");

		add(field1);
		add(field2);
		add(field3);
		add(field4);
		add(search);

		add(searchButton);
		add(searchLabel);

		add(label1);
		add(label2);
		add(label3);
		add(label4);

		setPreferredSize(new Dimension(500, 325));
	}
	
	private void create(){
		String key1 = field1.getFieldText();
		String key2 = field2.getFieldText();
		String key3 = field3.getFieldText();
		String key4 = field4.getFieldText();
		
		hashTable = new HashMap<String, String>(); //reset table - make empty

		if (key1.length() < 1){
			System.out.println("Nothing entered for key1, failed to add");
		}
		else{
			hashTable.put(key1, key1);
			System.out.println("Object " + key1 + " Created");
		}
		//duplicates are naturally handled by hashtable replacing them
		if (key2.length() < 1){
			System.out.println("Nothing entered for key2, failed to add");
		}
		else{
			hashTable.put(key2, key2);
			System.out.println("Object " + key2 + " Created");
		}

		if (key3.length() < 1){
			System.out.println("Nothing entered for key3, failed to add");
		}
		else{
			hashTable.put(key3, key3);
			System.out.println("Object " + key3 + " Created");
		}

		if (key4.length() < 1){
			System.out.println("Nothing entered for key4, failed to add");
		}
		else{
			hashTable.put(key4, key4);
			System.out.println("Object " + key4 + " Created");
		}
		
		System.out.println("Current HashTable: " + hashTable);
	}

	private class SearchListener implements ActionListener{

		public void actionPerformed(ActionEvent event){ //search button has been clicked
			
			create(); //create based on current fields every time a search is invoked
			
			String searchKey = search.getFieldText();
			
			if (searchKey.length() < 1){
				System.out.println("No Search Key Entered");
				return;
			}
			
			System.out.println("Searching for: " + searchKey);
			String value = hashTable.get(searchKey);
						
			if (value == null){
				System.out.println("Value Not Found");
				System.out.println();
				return;
			}
			
			System.out.println("Value " + value + " Found");
			System.out.println();
		}
	}
}

class FieldPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField field;

	public FieldPanel(String labelText, int fieldLength){
		
		label = new JLabel(labelText);
		field = new JTextField(fieldLength);

		add(label);
		add(field);

		setBackground(Color.MAGENTA);
		setPreferredSize(new Dimension(500, 40));
	}

	public String getFieldText(){
		return field.getText();
	}
}