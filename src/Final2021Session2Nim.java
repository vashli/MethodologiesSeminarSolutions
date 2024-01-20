import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
//ამოცანა 3. (30 ქულა) თამაში ნიმ
//თქვენი ამოცანაა დაწეროთ თამაში სახელად ნიმი. ნიმს ორი მოთამაშე თამაშობს, რომლებმაც 11 ქვისგან შემდგარი გროვა უნდა გაინაწილონ. თითოეულ მოთამაშეს ყოველ სვლაზე შეუძლია აიღოს 1, 2 ან 3 ქვა. მოთამაშე რომელიც აიღებს ბოლო ქვას წააგებს.
//პროგრამის გაშვებისას კანვასზე უნდა გამოჩნდეს ჰორიზონტალურად ერთმანეთის მიყოლებით ჩალაგებული 11 წრე. თითოეული წრის ფერი(შიგთავსი) უნდა იყოს GRAY, ხოლო კანტი კი BLACK. წრეების რიგი უნდა იყოს ფანჯრის ცენტრში როგორც ჰორიზონტალურად ისე ვერტიკალურად(ფანჯრის ზომის შეცვლისას გადახატვა საჭირო არ არის).
// 
//თამაშს იწყებს პირველი მოთამაშე და ისინი მორიგეობით აკეთებენ სვლებს. თუკი რომელიმე მოთამაშე დააკლიკებს ყველაზე მარჯვენა სამი წრისგან რომელიმეს, მაშინ ის წრე და მის მარჯვნივ მყოფი წრეები უნდა გაქრნენ. თუკი ნებისმიერ სხვა ადგილას დააკლიკებს მაშინ ეს კლიკი უნდა დააიგნოროთ. 
//მაგალითად თუკი პირველმა მოთამაშემ დააკლიკა მარჯვნიდან მესამე წრეს კანვასი შემდეგნაირად უნდა გამოიყურებოდეს
//
// 
//თუკი ამის შემდეგ მეორე მოთამაშემ დააკლიკა ყველაზე მარჯვენა წრეს მაშინ
// 
//თამაშის ბოლოს როცა ყველა წრე გაქრება უნდა გამოაჩინოთ თუ ვინ მოიგო. ტექსტი უნდა გამოჩნდეს (50,50) კოორდინატებზე
// 
//
//ამოხსნა დაწერეთ nim.java ფაილში.
//

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2Nim extends GraphicsProgram {
	private static final int N_COINS = 11; // ქვების რაოდენობა
	private static final int COIN_SIZE = 25; // ქვის ზომა
	private static final int COIN_STEP = 10; // ქვებს შორის მანძილი

	private ArrayList<GOval> coins;
	private int player = 0;

	public void run() {
		addCoins();
		addMouseListeners();
	}

	private void addCoins() {
		coins = new ArrayList<>();

		double startX = (getWidth() - N_COINS * COIN_SIZE - (N_COINS - 1) * COIN_STEP) / 2.0;
		for (int i = 0; i < N_COINS; i++) {
			GOval coin = new GOval(COIN_SIZE, COIN_SIZE);
			coin.setFilled(true);
			coin.setFillColor(Color.GRAY);
			double x = startX + i * (COIN_SIZE + COIN_STEP);
			double y = (getHeight() - COIN_SIZE) / 2;
			add(coin, x, y);
			coins.add(coin);
		}
	}

	public void mouseClicked(MouseEvent E) {
		GObject obj = getElementAt(E.getX(), E.getY());
		int num = -1;
		if (coins.size() > 0 && obj == coins.get(coins.size() - 1)) {
			num = 1;
		} else if (coins.size() > 1 && obj == coins.get(coins.size() - 2)) {
			num = 2;
		} else if (coins.size() > 0 && obj == coins.get(coins.size() - 3)) {
			num = 3;
		} else {
			return;
		}

		removeCoins(num);

		player = (player + 1) % 2;
		if (coins.size() == 0) {
			playerWon(player);
		}
	}

	private void playerWon(int player) {
		add(new GLabel("Player " + (player + 1) + " won!"), 50, 50);
	}

	private void removeCoins(int num) {
		for (int i = 0; i < num; i++) {
			remove(coins.get(coins.size() - 1));
			coins.remove(coins.size() - 1);
		}
	}
}
