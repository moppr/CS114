package b;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;
import a.InsertionSort;
import a.MergeSort;
import a.QuickSort;
import a.SelectionSortS;

public class SortingGUI extends JFrame{

	private JButton insertion = new JButton("Insertion Sort");
	private JButton merge = new JButton("Merge Sort");
	private JButton quick = new JButton("Quick Sort");
	private JButton selection = new JButton("Selection Sort");

	private JFrame frame = new JFrame("¯\\_(:|)_/¯");
	private JTextArea textArea = new JTextArea(
			"The intent is to provide players with a sense of pride and accomplishment for unlocking different heroes.\n"
			+ " As for cost, we selected initial values based upon data from the Open Beta and other adjustments made \n"
			+ "to milestone rewards before launch. Among other things, we're looking at average per-player credit earn \n"
			+ "rates on a daily basis, and we'll be making constant adjustments to ensure that players have challenges \n"
			+ "that are compelling, rewarding, and of course attainable via gameplay. We appreciate the candid feedback, \n"
			+ "and the passion the community has put forth around the current topics here on Reddit, our forums and across\n"
			+ " numerous social media outlets. Our team will continue to make changes and monitor community feedback and \n"
			+ "update everyone as soon and as often as we can.");

	private static String[] fileContents;
	private static final double nanoMult = Math.pow(10, -9);

	public static void main(String[] args) throws IOException{
		fillData();
		new SortingGUI();
	}

	public SortingGUI(){
		JPanel textField = new JPanel();
		JPanel buttons = new JPanel(new GridLayout(1, 4));
		textArea.setEditable(false);
		textField.add(textArea);
		frame.add(textField);
		frame.getContentPane().add(buttons, BorderLayout.NORTH);
		buttons.add(insertion);
		buttons.add(merge);
		buttons.add(quick);
		buttons.add(selection);

		insertion.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					long a = System.nanoTime();
					InsertionSort.Sort(fileContents, fileContents.length);
					long b = System.nanoTime();
					textArea.setText("Insertion Sort\nTime Elapsed: " + String.format("%.9f", nanoMult * (b - a)) + " seconds");
				}
			}
		);
		
		merge.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					long a = System.nanoTime();
					MergeSort.Sort(fileContents);
					long b = System.nanoTime();
					textArea.setText("Merge Sort\nTime Elapsed: " + String.format("%.9f", nanoMult * (b - a)) + " seconds");
				}
			}
		);
		
		quick.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					long a = System.nanoTime();
					QuickSort.Sort(fileContents);
					long b = System.nanoTime();
					textArea.setText("Quick Sort\nTime Elapsed: " + String.format("%.9f", nanoMult * (b - a)) + " seconds");
				}
			}
		);
		
		selection.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					long a = System.nanoTime();
					SelectionSortS kevinIsKindaCuteTbh = new SelectionSortS(fileContents);
					kevinIsKindaCuteTbh.sort();
					long b = System.nanoTime();
					textArea.setText("Selection Sort\nTime Elapsed: " + String.format("%.9f", nanoMult * (b - a)) + " seconds");
				}
			}
		);

		frame.setSize(720, 240);
		frame.setVisible(true);
		frame.setBackground(Color.ORANGE);
		frame.setLocationRelativeTo(null);
	}

	public static void fillData() throws IOException{
		String line;
		LinkedList<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "\\Lab 12\\b\\inventory.txt"));

		while ((line = br.readLine()) != null){
			list.add(line);
		}

		fileContents = list.toArray(new String[list.size()]);
	}
}
