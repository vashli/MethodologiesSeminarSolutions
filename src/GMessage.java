import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.*;

public class GMessage extends GCompound{
	private static final Color DEFAULT_BACKGROUND = Color.BLUE;
	private static final int DEFAULT_NUM_CHARS = 30;
	private static final int TEXT_MARGIN = 20;
	private Color bacgroundColor;
	private int numCharactersInLine; 
	private GCompound textCompound; 
	private GRect background;
	public GMessage(String text) {
		bacgroundColor = DEFAULT_BACKGROUND;
		numCharactersInLine = DEFAULT_NUM_CHARS;
		textCompound = createTextLabels(text);
		background = createBackground();
		add(background);
		add(textCompound, TEXT_MARGIN, TEXT_MARGIN);
	}
	
	
	private GRect createBackground() {
		GRect rect = new GRect(textCompound.getWidth() + 2 * TEXT_MARGIN, textCompound.getHeight() +  TEXT_MARGIN);
		rect.setFilled(true);
		rect.setColor(bacgroundColor);
		return rect;
	}


	private ArrayList<String> splitTextIntoLines(String text){
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0; i < text.length(); i+= numCharactersInLine) {
			int j = Math.min(i + numCharactersInLine, text.length());
			String line = text.substring(i, j);
			res.add(line);
		}
		return res;
	}
	
	private GCompound createTextLabels(String text) {
		GCompound textLabels = new GCompound();
		ArrayList<String> lines = splitTextIntoLines(text);
		double x = 0;
		double y = 0;
		for (int i = 0 ; i < lines.size(); i++) {
			String line = lines.get(i);
			GLabel label = new GLabel(line);
			textLabels.add(label, x, y);
			
			y += TEXT_MARGIN;
		}
		return textLabels;
	}
}
