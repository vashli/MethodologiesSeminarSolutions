import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

//42. Paint-ის მონაკვეთის ხატვის გაკეთება, ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო, მერე
//მაუსის მოძრაობისას მონაკვეთიც მოძრაობს რადგან მეორე წვერო არაა დაფიქსირებული და
//კლიკით ფიქსირდება მეორე წვეროც
public class Problem42 extends GraphicsProgram{
	private int prevX;
	private int prevY;
	private GLine line;
	
	public void init(){
		addMouseListeners(); 
	}

	public void mouseDragged(MouseEvent e){
		line.setEndPoint(e.getX(), e.getY());
	}
	
	public void mousePressed(MouseEvent e){
		prevX = e.getX();
		prevY = e.getY();
		
		line = new GLine(prevX, prevY, e.getX(), e.getY());
		add(line);
	}
	
}
