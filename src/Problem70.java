import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import acm.graphics.*;
import acm.program.*;

//70. მთელ ფორმაზე ბადის დახატვა, ისე რომ ფორმის ზომის ცვლილებაზე ბადის უჯრის ზომაც
//პროპორციულად იზრდებოდეს. 

public class Problem70 extends GraphicsProgram implements ComponentListener {
	private static final int N = 10;

	public void init() {
		addComponentListener(this);
	}

	public void run() {
		addGrid();
	}

	private void addGrid() {
		int width = getWidth() / N;
		int height = getHeight() / N;

		for (int i = 1; i < N; i++) {
			// Horizontal line
			add(new GLine(0, height * i, getWidth(), height * i));
			// Vertical line
			add(new GLine(width * i, 0, width * i, getHeight()));
		}
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// println("resize");
		removeAll();
		addGrid();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

}
