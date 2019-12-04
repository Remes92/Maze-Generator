package square;

import java.awt.Point;
import java.util.List;

public class Square {

	private Point coordinates; 
	private SquareIdentity identity;
	private Neighbors neighbors = null;
	private int weight = 0;
	
	public Square(int x, int y, int weight, SquareIdentity identity) {
		this.coordinates = new Point(x,y);
		this.identity = identity;
		this.neighbors = new Neighbors();
		this.weight = weight;
	}
	
	public Point getCoordinates() {
		return this.coordinates;
	}
	public void setCoordinates(int x, int y) {
		this.coordinates.setLocation(x, y);
	}
	public SquareIdentity getIdentity() {
		return this.identity;
	}
	public void setIdentity(SquareIdentity identity) {
		this.identity = identity;
	}
	public Neighbors getNeighbors() {
		return this.neighbors;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
