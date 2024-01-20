import acm.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

//დაწერეთ SimpleTextEditor(© r.meishvili): პროგრამა უნდა შეიცავდეს მთავარ ტექსტის არეას, სამხრეთით ორ ღილაკს: open, close. 
//open-ზე დაჭერისას უნდა გამოვარდეს შემდეგი ფანჯარა: გამოიყენეთ JFileChooser
//მთავარ ფანჯარაში უნდა შეგეძლოთ ტექსტის დაედიტება - JTextArea
//Save - ზე დაჭერისას უნდა ინახავდეთ შეცვლილ ფაილს
//Tags: Interactors, File read/write

public class Final07 extends Program {
	JFileChooser chooser = new JFileChooser();
	JPanel mainPanel = new JPanel();
	JTextArea textArea = new JTextArea();
	JButton openButton = new JButton("open");
	JButton saveButton = new JButton("save");
	private String savedFilePath = "";

	@Override
	public void init() {
		initMainPanel();
		initChooser();
		add(openButton, SOUTH);
		add(saveButton, SOUTH);
		addActionListeners();
	}

	private void initMainPanel() {
		add(mainPanel, CENTER);
		mainPanel.add(textArea);
		textArea.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
		textArea.setMargin(new Insets(5, 5, 5, 5));
	}

	private void initChooser() {
		chooser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		if (e.getSource() == openButton) {
			handleOpenButton(e);
		} else if (e.getSource() == chooser) {
			handleChooserEvent(e);
		} else if (e.getSource() == saveButton) {
			saveToFile(textArea.getText());
		}
	}

	private void saveToFile(String fileText) {
		try {
			FileWriter fileWriter = new FileWriter(savedFilePath);
			BufferedWriter writer = new BufferedWriter(fileWriter);

			writer.write(fileText);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleOpenButton(ActionEvent e) {
		chooser.showOpenDialog(this);
	}

	private void handleChooserEvent(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "ApproveSelection":
			textArea.setText("");
			tryReadingFromFile(chooser.getSelectedFile().getAbsolutePath());
			break;
		case "CancelSelection":
			break;
		}
	}

	private void tryReadingFromFile(String path) {
		savedFilePath = path;
		System.out.println(path);
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader reader = new BufferedReader(fileReader);

			String fullText = "";
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				fullText += line + '\n';
			}

			textArea.setText(fullText);

			fileReader.close();
		} catch (FileNotFoundException e) {
			handleError(e);
		} catch (IOException e) {
			handleError(e);
		}
	}

	private void handleError(Exception e) {

	}

}
