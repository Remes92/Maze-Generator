package square;

public class Neighbors {
	private Square north = null;
	private Square south = null;
	private Square east = null;
	private Square west = null;
	private Square northWest = null;
	private Square northEast = null;
	private Square southWest = null;
	private Square southEast = null;
	
	public Square getNorthNeighbor() {
		return north;
	}
	public void setNorthNeighbor(Square topNeighbor) {
		this.north = topNeighbor;
	}
	public Square getSouthNeighbor() {
		return south;
	}
	public void setSouthNeighbor(Square botNeighbor) {
		this.south = botNeighbor;
	}
	public Square getEastNeighbor() {
		return east;
	}
	public void setEastNeighbor(Square rightNeighbor) {
		this.east = rightNeighbor;
	}
	public Square getWestNeighbor() {
		return west;
	}
	public void setWestNeighbor(Square leftNeighbor) {
		this.west = leftNeighbor;
	}
	public Square getNorthWestNeighbor() {
		return northWest;
	}
	public void setNorthWestNeighbor(Square northWest) {
		this.northWest = northWest;
	}
	public Square getNorthEastNeighbor() {
		return northEast;
	}
	public void setNorthEastNeighbor(Square northEast) {
		this.northEast = northEast;
	}
	public Square getSouthWestNeighbor() {
		return southWest;
	}
	public void setSouthWestNeighbor(Square southWest) {
		this.southWest = southWest;
	}
	public Square getSouthEastNeighbor() {
		return southEast;
	}
	public void setSouthEastNeighbor(Square southEast) {
		this.southEast = southEast;
	}
}
