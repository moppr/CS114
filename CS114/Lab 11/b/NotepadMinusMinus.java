package b;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NotepadMinusMinus extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotepadMinusMinus() {
		readFile();
		fileEditor();
	}

	private File selectedFile;
	private String selectedFileContents = "";
	private JButton SaveAndExit = new JButton("Save Changes and Close");
	private JButton Exit = new JButton("Exit Without Saving");
	private JFrame frame = new JFrame("NotePad--");
	private JTextArea textArea = new JTextArea();
	
	

	private void readFile() {
		try {
			//default location
			String path = System.getProperty("user.dir") + "\\Part 2";
			JFileChooser aFileChooser = new JFileChooser(path);
			
			int returnValue = aFileChooser.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = aFileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
				Scanner scan = new Scanner(selectedFile);
				
				//get contents of file
				while (scan.hasNextLine()) {
					String temp = scan.nextLine() + "\n";
					selectedFileContents = selectedFileContents + temp;
				}
				scan.close();
				textArea.setText(selectedFileContents); //sets text editor contents to that of file
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void fileEditor() {
		JPanel textField = new JPanel(new GridLayout(1, 1));
		JPanel buttons = new JPanel(new GridLayout(1, 2));
		textField.add(textArea);
		frame.add(textField);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.add(SaveAndExit);
		buttons.add(Exit);
		
		//Listener for Close
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		
		//Listener for Save
		SaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
				frame.dispose();
			}
		});
		
		frame.setSize(69*10, 420);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	private void save() {
		try {
			String path = selectedFile.getAbsolutePath();
			//create a new file w/ same name as original
			File newFile = new File(path.substring(path.lastIndexOf(",") + 1));
			//write edited text to new file
			FileWriter aWriter = new FileWriter(newFile);
			aWriter.write(textArea.getText());
			aWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
