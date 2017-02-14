package DrawPanel;

import java.awt.Point;
import java.util.ArrayList;

public class Strokes {

	private ArrayList<ArrayList<Point>> strokes;
	
	public Strokes() {
		strokes = new ArrayList<>();
	}
	
	public ArrayList<ArrayList<Point>> getStrokes() {
		return strokes;
	}
	
	public void addStroke(ArrayList<Point> stroke){
		strokes.add(stroke);
	}
	
	public ArrayList<Point> getCurStroke() {
		return strokes.get(strokes.size()-1);
	}
	
	public int size() {
		return strokes.size();
	}
	
	
	
}
