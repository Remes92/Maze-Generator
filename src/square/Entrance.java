package square;

public class Entrance extends Square{
	
	private static int entranceWeight = 0;
	
	public Entrance(int x, int y) {
		super(x, y, entranceWeight,SquareIdentity.ENTRANCE);	
	}
	
	
}
