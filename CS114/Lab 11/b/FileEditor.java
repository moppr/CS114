package b;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class FileEditor{

	public static void main(String[] args) throws FileNotFoundException{
		new FileProgram();
	}
}

class FileProgram extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private String contents = "";
	private JButton save = new JButton("Save & Close");
	private JButton close = new JButton("Exit ");
	private JFrame frame = new JFrame("hi kevin");
	private JTextArea textArea = new JTextArea();

	public FileProgram() throws FileNotFoundException{
		readFile();
		fileEditor();
	}

	private void readFile() throws FileNotFoundException{
		String path = System.getProperty("user.dir") + "\\Lab 11\\b";
		JFileChooser fileChooser = new JFileChooser(path);

		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
			System.out.println(file.getAbsolutePath());
			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()){
				contents = contents + scan.nextLine() + "\n";
			}
			textArea.setText(contents);
		}

	}

	private void fileEditor(){
		JPanel textField = new JPanel(new GridLayout(1, 1));
		JPanel buttons = new JPanel(new GridLayout(1, 2));
		textField.add(textArea);
		frame.add(textField);
		frame.getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.add(save);
		
		save.addActionListener(				
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						save();
					}
					catch (IOException e1){
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();
				}
			}
		);

		frame.setSize(1820, 1340);
		setBackground(Color.GREEN);
		frame.setVisible(true);
	}

	private void save() throws IOException{
		String path = file.getAbsolutePath();
		File newFile = new File(path.substring(path.lastIndexOf(",") + 1));
		FileWriter writer = new FileWriter(newFile);
		writer.write(textArea.getText());
		writer.close();
	}
}
