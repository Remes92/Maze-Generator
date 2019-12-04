package square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
	private List<List<Square>> squareGrid = null;
	
	public Grid() {

		this.squareGrid = new ArrayList<List<Square>>();
	}
	public List<List<Square>> getGrid(){
		return this.squareGrid;
	}
	public void addRow(List<Square> sList){
		this.squareGrid.add(sList);
	}
	public Square getSquareByCordinates(int x, int y) {
		return this.squareGrid.get(y).get(x);
	}
}
