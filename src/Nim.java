import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Nim extends GraphicsProgram {
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
