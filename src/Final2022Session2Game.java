import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
//ამოცანა 4. (30 ქულა) თამაში
//თქვენი ამოცანაა დაწეროთ გრაფიკული პროგრამა, რომელიც მოგვცემს ბურთთან
//თამაშის შესაძლებლობას. პროგრამის გაშვებისას BALL_SIZE ზომის ბურთი უნდა
//გაჩნდეს ფანჯრის ცენტრში და დაიწყოს შემთხვევითი სიჩქარით და
//მიმართულებით მოძრაობა. ფანჯრის ოთხივე კედლებზე დაჯახების შემთხვევაში
//ბუთრი უნდა აირეკლოს და იცვლიდეს მიმართულებას(ისევე როგორც ბრეიქაუთში).
//ფანჯარას სამხრეთ რეგიონზე უნდა ჰქონდეს ორი ტექსტფილდი რომლებშიც
//შეგვიძლია ჩავწეროთ მთელი რიცხვები Vx ან Vy. ტექსტფილდში რიცხვის
//ჩაწერის და ენტერზე დაჭერის შემთხვევაში ბურთის სიჩქარე უნდა იცვლებოდეს
//იმ რიცხვით რაც ჩაიწერა(თუკი მარცხენა ტექსტფილდში ჩავწერეთ მაშინ უნდა
//შეიცვალოს ბურთის x ღერძის მიმართ სიჩქარე, თუკი მარჯვენაში მაშინ უნდა
//შეიცვალოს y ღერძის მიმართ სიჩქარე). ჩათვალეთ, რომ ტექსტფილდში
//მომხმარებელი ყოველთვის მთელ რიცხვს ჩაწერს.
//ბურთზე შეგვიძლია მაუსით ზემოქმედება. კერძოდ, თუკი ბურთს სამჯერ ზედიზედ
//დააკლიკებთ მაუსით მაშინ ის უნდა გაჩერდეს. ხოლო თუკი გაჩერებულ ბურთს
//ორჯერ ზედიზედ დააკლიკებთ მაშინ განაგრძოს მოძრაობა იმ სიჩქარით და
//მიმართულებით რა სიჩქარითაც მოძრაობდა მანამდე.
//ბურთზე ზედიზედ დაკლიკება ნიშნავს რომ ბურთზე ერთი დაკლიკებიდან მეორე
//დაკლიკებამდე მომხმარებელს სხვაგან არსად არ დაუკლიკებია.
//ამოხსნა დაწერეთ game.java ფაილში
public class Final2022Session2Game extends GraphicsProgram{
	private static final int BALL_SIZE = 20;
	private static final int DELAY = 100;
	
	private static final double MIN_V = 1;
	private static final double MAX_V = 3;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private JTextField vxField;
	private JTextField vyField;
	
	private GOval ball;
	private double vx;
	private double vy;
	private int clickCount = 0;
	private boolean paused = false;
	public void init() {
		vxField = new JTextField(5);
		vyField = new JTextField(5);
		
		add(vxField, SOUTH);
		add(vyField, SOUTH);
		
		vxField.addActionListener(this);
		vyField.addActionListener(this);
		
		addMouseListeners();
		
		ball = new GOval(2 * BALL_SIZE, 2* BALL_SIZE);
		ball.setFilled(true);
		add(ball, getWidth() / 2 - BALL_SIZE, getHeight() / 2 - BALL_SIZE);
		vx = rgen.nextDouble(MIN_V, MAX_V);
		vy = rgen.nextDouble(MIN_V, MAX_V);
		if(rgen.nextBoolean()) {
			vx *= -1;
		}
		if(rgen.nextBoolean()) {
			vy *= -1;
		}
	}
	
	public void run() {
		while(true) {
			if(ball.getX() <= 0 ) {
				vx = Math.abs(vx);
			}else if(ball.getX() + 2 * BALL_SIZE > getWidth()){
				vx = - Math.abs(vx);
			}
			if(ball.getY() <= 0 ) {
				vy = Math.abs(vy);
			}else if(ball.getY() + 2 * BALL_SIZE > getHeight()){
				vy = - Math.abs(vy);
			}
			if(!paused) {
				ball.move(vx, vy);
			}
			pause(DELAY);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vxField) {
			vx = Integer.parseInt(vxField.getText());
		}
		if(e.getSource() == vyField) {
			vy = Integer.parseInt(vyField.getText());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(getElementAt(e.getX(), e.getY()) == ball) {
			clickCount ++;
		}else {
			clickCount = 0;
		}
		
		if(paused && clickCount == 2) {
			paused = false;
			clickCount = 0;
		}
		
		if(!paused && clickCount == 3) {
			paused = true;
			clickCount = 0;
		}
	}
	
	
}