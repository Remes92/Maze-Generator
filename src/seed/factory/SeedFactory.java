package seed.factory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import factory.XMLHandler;

public class SeedFactory {
	private XMLHandler xml;

	protected SeedFactory() {
			xml = XMLHandler.getInstance();
	}
	//TODO fixa så det går att läsa in flera element från xml filen och gör att det är möjligt att hämta en specifik genom id.

	

	

	

}
