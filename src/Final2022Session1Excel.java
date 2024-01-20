import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.*;

import acm.graphics.*;
import acm.program.GraphicsProgram;

//ამოცანა 4. (35 ქულა) ცხრილი
//თქვენი მიზანია დაწეროთ გრაფიკული პროგრამა, რომლის საშუალებითაც
//შეგვეძლება ცხრილის გაკეთება. ცხრილი შედგება სვეტებისა და
//სტრიქონებისგან. ყოველ სვეტს გააჩნია თავისი სათაური. პროგრამა
//შემდეგნაირად გამოიყურება:
//მას აქვს 6 ინტერაქტორი SOUTH რეგიონზე:
//1. add column ღილაკზე დაჭერისას პროგრამამ უნდა წაიკითხოს პირველ
//ტექსტფილდში არსებული ტექსტი და ამ სათაურის მქონე სვეტი დაამატოს ცხრილს
//მარჯვნიდან. პირველი სვეტი უნდა დაიწყოს (COLUMN_START_X,
//COLUMN_START_Y) კოორდინატებზე, ყოველი შემდეგი სვეტის დასაწყისი წინა
//სვეტის დასაწყისისგან COLUMN_STEP პიქსელით უფრო მარჯვნივაა. დამატებისას
//სვეტში სათაურის გარდა ყველა სხვა სტრიქონი ცარიელი უნდა იყოს.
//ჩათვალეთ, რომ დამატებული სვეტები ფანჯრის საზღვრებს არ გასცდება. ასევე
//ჩათვალეთ, რომ სათაური, ასევე სტრიქონებში ასებული ტექსტიც ყოველთვის
//დაეტევა COLUMN_STEP პიქსელში.
//სათაურსა და სვეტებს შორის უნდა იყოს გავლებული ხაზი, რომელიც
//(COLUMN_START_X, COLUMN_START_Y) კოორდინატებზე იწყება და
// თბილისის თავისუფალი უნივერსიტეტი
//COLUMN_START_X, COLUMN_START_Y + COLUMN_STEP * N) კოორდინატებზე
//მთავრდება, სადაც N სვეტების რაოდენობაა.
//2. add row ღილაკზე დაჭერისას პროგრამამ უნდა წაიკითხოს მეორე
//ტექსტფილდში არსებული ტექსტი, გაანალიზოს და ცხრილს დაამატოს მორიგი
//სტრიქონი. წაკითხულ ტექსტში ‘;’ სიმბოლოთი იქნება გამოყოფილი ამ
//სტრიქონის შესაბამისი სვეტების ინფორმაცია მაგალითად თუკი გვაქვს 4 სვეტი
//მაშინ შემდეგი ტექსტი “john;smith;21;3.56” ნიშნავს, რომ ამ სტრიქონის
//პირველ სვეტში უნდა ჩაიწეროს john, მეორეში smith, მესამეში 21 მეოთხეში
//კი 3.56. მორიგი სტრიქონის დამატება უნდა მოხდეს წინა სტრიქონიდან
//ROW_STEP პიქსელით ქვემოთ.
//ჩათვალეთ, რომ მომხმარებელი ზუსტად იმდენ ‘;’ სიმბოლოთი გამოყოფილ
//სიტყვას შემოიყვანს რამდენი სვეტიცაა ამ მომენტში ცხრილში არც მეტს არც
//ნაკლებს.
//3. search ღილაკზე დაჭერისას პროგრამამ უნდა წაიკითხოს მესამეტექსტფილდში
//არსებული ტექსტი, მოძებნოს მომხმარებლის მიერ შეყვანილ სტრიქონებში თუკი
//სადმე გვხვდება ეს ტექსტი და გამოაჩინოს ცხრილში მხოლოდ ეს სტრიქონები.
//სტრიქონები რომლებშიც ეს ტექსტი არ გვხვდება არ უნდა გამოჩნდეს.
//თუმცა ეს სტრიქონები მეხსიერებიდან არ უნდა წაიშალოს და როდესაც
//მომხმარებელი ახალ სტრიქონს დაამატებს ყველა ძველი სტრიქონი ამ ახალ
//სტრიქონთან ერთად უნდა გამოჩნდეს. ან თუკი სხვა ტექსტს ჩაწერს
//მოსაძებნად, მაშინ სხვა შესაბამისი სტრიქონები უნდა მოძებნოს.
//ამოხსნა დაწერეთ excel.java ფაილში
public class Final2022Session1Excel extends GraphicsProgram {
	private static final int COLUMN_START_X = 10;
	private static final int COLUMN_START_Y = 20;
	private static final int ROW_STEP = 20;
	private static final int COLUMN_STEP = 100;

	private JTextField colField;
	private JTextField rowField;
	private JTextField filterField;
	private JButton colButton;
	private JButton rowButton;
	private JButton filterButton;

	private ArrayList<String> columnNames;
	private ArrayList<ArrayList<String>> rows;

	public void init() {
		colField = new JTextField(10);
		rowField = new JTextField(10);
		filterField = new JTextField(10);
		colButton = new JButton("add column");
		rowButton = new JButton("add row");
		filterButton = new JButton("filter");

		add(colField, SOUTH);
		add(colButton, SOUTH);
		add(rowField, SOUTH);
		add(rowButton, SOUTH);
		add(filterField, SOUTH);
		add(filterButton, SOUTH);

		addActionListeners();

		columnNames = new ArrayList<>();
		rows = new ArrayList<>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == colButton) {
			addColumn(colField.getText());
		} else if (e.getSource() == rowButton) {
			addRow(rowField.getText());
		} else if (e.getSource() == filterButton) {
			filterRows(filterField.getText());
		}
	}

	private void filterRows(String text) {
		showGrid(text);
	}

	private void addRow(String text) {
		StringTokenizer tokenizer = new StringTokenizer(text, ";");
		ArrayList<String> newRow = new ArrayList<>();
		while (tokenizer.hasMoreTokens()) {
			newRow.add(tokenizer.nextToken());
		}
		rows.add(newRow);

		showGrid(null);
	}

	private void showGrid(String filterWrd) {
		displayColumnNames();
		int y = COLUMN_START_Y;
		for (ArrayList<String> row : rows) {
			if (filterWrd == null || row.contains(filterWrd)) {
				y += ROW_STEP;
				displayRow(row, y);
			}
		}
	}

	private void addColumn(String text) {
		columnNames.add(text);
		displayColumnNames();
	}

	private void displayColumnNames() {
		removeAll();
		displayRow(columnNames, COLUMN_START_Y);
		GLine line = new GLine(COLUMN_START_X, COLUMN_START_Y, COLUMN_START_X + COLUMN_STEP * columnNames.size(),
				COLUMN_START_Y);
		add(line);
	}

	private void displayRow(ArrayList<String> row, int y) {
		int x = COLUMN_START_X;
		for (int i = 0; i < row.size(); i++) {
			GLabel label = new GLabel(row.get(i));
			add(label, x, y);
			x += COLUMN_STEP;
		}
	}

}