package factory;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.ObjectInputStream.GetField;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.EventFilter;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.XMLEventAllocator;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;


public class XMLHandler {
	private static XMLHandler xmlHandler = null;
	private JAXBContext jaxbContext;
	private File file;
	private Unmarshaller jaxbUnmarshaller;
	private Marshaller jaxbMarshaller;

	private XMLHandler() {
	}

	public static XMLHandler getInstance() {
		if (xmlHandler == null) {
			xmlHandler = new XMLHandler();
		}
		return xmlHandler;
	}

	public void setFile(String filePath) {
		this.file = new File(filePath);
	}

	public Object readXML(Class c) {
		try {
			Object o = c.newInstance();
			this.jaxbContext = JAXBContext.newInstance(o.getClass());
			this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object object = (o.getClass().cast(jaxbUnmarshaller.unmarshal(file)));
			return object;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void writeToXML(Object o) {
		try {
			this.jaxbContext = JAXBContext.newInstance(o.getClass());
			this.jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(o, file);
		} catch (PropertyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object readXMLByAttribute(Class c, int id) {
        try {
        	XMLInputFactory xif = XMLInputFactory.newFactory();
        	StreamSource xml = new StreamSource(this.file);
			XMLStreamReader xsr = xif.createXMLStreamReader(xml);
			//xsr.nextTag();
			int eventType;
			while(xsr.hasNext()) {
				eventType = xsr.next();
				if(eventType == XMLStreamReader.START_ELEMENT) {
					if(xsr.getLocalName().equals(c.getSimpleName().toLowerCase()) && xsr.getAttributeCount()>0) {
						for(int i=0; i<xsr.getAttributeCount();i++) {
							if(xsr.getAttributeValue(i).equals(String.valueOf(id))) {
								Object o = c.newInstance();
								this.jaxbContext = JAXBContext.newInstance(o.getClass());
								this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
								Object object = (o.getClass().cast(this.jaxbUnmarshaller.unmarshal(xsr)));
								return object;
							}
						}
					}
				}
			}
			
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
