package seed;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import factory.XMLHandler;
import maze.Maze;
import square.Grid;
import square.Square;
import square.SquareIdentity;

public class SeedGenerator {
	private Seed loadedSeed;
	
	
	public SeedGenerator() {
//		XMLHandler x = XMLHandler.getInstance();
//		x.setFile("src\\resources\\SeedSettings.xml");
//		Seeds xmlResponse = (Seeds)x.readXML(Seeds.class);
//		List<Seed> seeds = xmlResponse.getSeeds();
//		Seed s = (Seed)x.readXMLByAttribute(Seed.class, 1);
//		System.out.println(s.toString());
//		for(int i = 0; i<seeds.size(); i++) {
//			System.out.println(seeds.get(i).toString());
//		}
		Maze maze = new Maze(10,10,new Grid());
		System.out.println(maze.toString());
		
	}
	
	public Seed getSeed() {
		return loadedSeed;
	}
}
