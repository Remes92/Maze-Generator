package maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import square.Entrance;
import square.Exit;
import square.Grid;
import square.Square;
import square.SquareIdentity;

public class Maze {
	private int height = 0;
	private int width = 0;
	private Grid grid = null;
	private Random rand = null;
	private Square entrance = null;
	private Square exit = null;
	private List<Square> path = null;

	public Maze(int height, int width, Grid grid) {
		this.height = height;
		this.width = width;
		this.grid = grid;
		this.rand = new Random();
		this.path = new ArrayList<Square>();
		initializeMaze();
		int entranceSide = createEntrance();
		createExit(entranceSide);
		instantiateNeighbors();
		this.path.add(entrance);
		createGroud(this.entrance);
		List<Square> l = new ArrayList<Square>();
		l.add(new Entrance(1, 1));
		System.out.println(l.get(0).getIdentity());
		System.out.println(l.size());
		l.set(0, new Exit(l.get(0).getCoordinates().x, l.get(0).getCoordinates().y));
		System.out.println(l.size());
		System.out.println(l.get(0).getIdentity());
		
	}
	
	

	private void createGroud(Square square) {
		Square nextSquare = pickValidNeighbor(square);
		

	}


	private Square pickValidNeighbor(Square square) {
		List<Square> validNeighbors = new ArrayList<Square>();
		if (validateNeighbor(square.getNeighbors().getNorthNeighbor()))
			validNeighbors.add(square.getNeighbors().getNorthNeighbor());
		if (validateNeighbor(square.getNeighbors().getSouthNeighbor()))
			validNeighbors.add(square.getNeighbors().getSouthNeighbor());
		if (validateNeighbor(square.getNeighbors().getEastNeighbor()))
			validNeighbors.add(square.getNeighbors().getEastNeighbor());
		if (validateNeighbor(square.getNeighbors().getWestNeighbor()))
			validNeighbors.add(square.getNeighbors().getWestNeighbor());

		if (validNeighbors.size() > 0) {
			int randomNeighbor = getRandomNumber(validNeighbors.size());
			return validNeighbors.get(randomNeighbor);
		}
		return null;
	}
	
	private boolean possibleToMove(Square side1,Square side2) {
		
		
		return true;
	}
	
	private boolean validateNeighbor(Square square) {
		if (square != null) {
			if (square.getIdentity() == SquareIdentity.INNERWALL) {
				return true;
			}
		}
		return false;
	}
	
	
	private int createEntrance() {
		int entranceSide = getRandomNumber(4);
		int entrancePos = 0;
		if (entranceSide < 2)
			entrancePos = randomizeValidPlacement(this.width);
		else
			entrancePos = randomizeValidPlacement(this.height);
		changeSquareIdentity(entranceSide, entrancePos, false);
		return entranceSide;
	}

	private void changeSquareIdentity(int side, int pos, boolean isExit) {
		SquareIdentity id = null;
		Square square = null;
		if (isExit)
			id = SquareIdentity.EXIT;
		else
			id = SquareIdentity.ENTRANCE;
		switch (side) {
		case 0:
			square = this.grid.getGrid().get(0).get(pos);
			break;
		case 1:
			square = this.grid.getGrid().get(this.height - 1).get(pos);
			break;
		case 2:
			square = this.grid.getGrid().get(pos).get(0);
			break;
		case 3:
			square = this.grid.getGrid().get(pos).get(this.width - 1);
			break;
		}
		square.setIdentity(id);
		if (isExit)
			this.exit = square;
		else
			this.entrance = square;
	}

	private void createExit(int entranceSide) {
		int exitSide = getRandomNumber(4);
		while (exitSide == entranceSide) {
			exitSide = getRandomNumber(4);
		}
		int exitPos = 0;
		if (exitSide < 2)
			exitPos = randomizeValidPlacement(this.width);
		else
			exitPos = randomizeValidPlacement(this.height);

		changeSquareIdentity(exitSide, exitPos, true);
	}

	private int randomizeValidPlacement(int limit) {
		return rand.nextInt(limit - 2) + 1;
	}

	private int getRandomNumber(int value) {
		return this.rand.nextInt(value);
	}

	private void instantiateNeighbors() {
		Square square = null;
		for (int i = 0; i < this.grid.getGrid().size(); i++) {
			for (int j = 0; j < this.grid.getGrid().get(i).size(); j++) {
				square = this.grid.getGrid().get(i).get(j);
				if ((square.getCoordinates().y - 1 >= 0)) 
					square.getNeighbors().setNorthNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x, square.getCoordinates().y - 1));
				if (square.getCoordinates().y + 1 <= this.grid.getGrid().size() - 1)
					square.getNeighbors().setSouthNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x, square.getCoordinates().y + 1));
				if ((square.getCoordinates().x - 1 >= 0))
					square.getNeighbors().setWestNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x - 1, square.getCoordinates().y));
				if (square.getCoordinates().x + 1 <= this.grid.getGrid().get(i).size() - 1)
					square.getNeighbors().setEastNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x + 1, square.getCoordinates().y));
				if(square.getCoordinates().y-1 >=0 && square.getCoordinates().x-1 >=0)
					square.getNeighbors().setNorthWestNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x-1, square.getCoordinates().y-1));
				if(square.getCoordinates().y-1 >=0 && square.getCoordinates().x+1 <=this.grid.getGrid().get(i).size() - 1)
					square.getNeighbors().setNorthEastNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x+1, square.getCoordinates().y-1));		
				if(square.getCoordinates().y+1 <=this.grid.getGrid().size() - 1 && square.getCoordinates().x-1 >=0)
					square.getNeighbors().setSouthWestNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x-1, square.getCoordinates().y+1));
				if(square.getCoordinates().y+1 <=this.grid.getGrid().size()-1 && square.getCoordinates().x+1 <= this.grid.getGrid().get(i).size()-1)
					square.getNeighbors().setSouthEastNeighbor(
							this.grid.getSquareByCordinates(square.getCoordinates().x+1, square.getCoordinates().y+1));
				
			}
		}
	}

	private void initializeMaze() {
		for (int i = 0; i < this.height; i++) {
			List<Square> squares = new ArrayList<Square>();
			for (int j = 0; j < this.width; j++) {
				if (i == 0 || i == this.height - 1 || j == 0 || j == this.width - 1) {
					squares.add(new Square(j, i, -1,SquareIdentity.OUTERWALL));
				} else {
					squares.add(new Square(j, i,0, SquareIdentity.INNERWALL));
				}

			}
			this.grid.addRow(squares);
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < grid.getGrid().size(); i++) {
			for (int j = 0; j < grid.getGrid().get(i).size(); j++) {
				s = s + "[" + grid.getGrid().get(i).get(j).getWeight() + "]";
			}
			s = s + "\n";
		}
		return s;
	}
}
