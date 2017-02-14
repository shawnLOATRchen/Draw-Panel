package DrawPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;


public class DrawPanel extends JPanel {
	
	int width, height;
	boolean isDraw = false, isStart = false;
	Strokes strokes = new Strokes();

	public boolean doClean = false;
	
	public DrawPanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setSize(width, height);

		this.addMouseListener(new MouseAdapter() {

			// when mouse pressed add a new stroke and become drawing state
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				super.mousePressed(e);
				isDraw = true;
				isStart = true;
				doClean = false;
				strokes.addStroke(new ArrayList<Point>());
			}

			// when mouse release finish drawing and exit drawing state
			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				super.mouseReleased(e);
				isDraw = false;
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			// when mouse move and if it is in drawing state, draw line
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				super.mouseDragged(e);
				if (isDraw){
					Point p = e.getPoint();
					if(p.x >0 && p.x <width && p.y > 0 && p.y <height){
						strokes.getCurStroke().add(p);
					}
				}
				repaint();
			}
		});


	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// clean the graph
		if (doClean) g.drawLine(0, 0, 0, 0);
		// drawing each stroke by connect the point to previous point.
		else if (isStart) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(Color.BLACK);
			g2D.setStroke(new BasicStroke(3.5f));
			for (ArrayList<Point> stroke : strokes.getStrokes()) {
				for (int i = 1; i < stroke.size(); i++) {
					g2D.drawLine(stroke.get(i-1).x, stroke.get(i-1).y, stroke.get(i).x, stroke.get(i).y);
				}
			}
		} 
	}

	public void cleanPanel() {
		doClean = true;
		repaint();
	}
}
