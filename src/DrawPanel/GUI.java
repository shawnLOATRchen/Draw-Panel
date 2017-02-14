package DrawPanel;

import java.awt.Color;
import javax.swing.JFrame;

public class GUI {
	// parameters
	int GUI_WIDTH = 640, GUI_HEIGHT = 360;
	int DRAW_WIDTH = 640, DRAW_HEIGHT = 360;
	
	JFrame frame;
	DrawPanel drawPanel;
	public GUI (){
		frame = new JFrame("Drawing Board");
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setBackground(Color.BLUE);
		drawPanel = new DrawPanel(DRAW_WIDTH, DRAW_HEIGHT);
		drawPanel.setBackground(Color.WHITE);
		frame.add(drawPanel);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
