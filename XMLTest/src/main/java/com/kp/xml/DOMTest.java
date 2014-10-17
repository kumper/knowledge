package com.kp.xml;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * DOM to bardziej rozbudowany silnik odczytu dokumentów XML.
 * 
 * @author ParzychK
 */
public class DOMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Podstawowy parser to (wykorzystuje język IDL (Interface Definition Language) dzięki czemu można z niego korzystać w innych językach programowania):
//		org.apache.xerces.parsers.DOMParser (potrzebny jeszcze org.w3c.dom.* żeby działało)
//		
//		Specjalnie dla Javy mamy dwie biblioteki:
//			JDOM (rozwijane jako (JSR 102); oparte na klasach konkretnych-nie interfejsach)
//			DOM4J (korzysta z SAX(?))
//			
//		W tym przykładzie używamy DOM4J
		
        try {
            SAXReader reader = new SAXReader();
			Document document = reader.read("file.xml");
			
			Element root = document.getRootElement();
			Element idoc = (Element) root.elements("IDOC").get(0);
			Element ZAWZ1STA01 = (Element) idoc.elements("ZAWZ1STA01").get(0);
			Element ZAWZ1HDR01 = (Element) ZAWZ1STA01.elements("ZAWZ1HDR01").get(0);
			Element REJESTRATOR = (Element) ZAWZ1HDR01.elements("REJESTRATOR").get(0);
			
			System.out.println(REJESTRATOR.getText());
			
			for (Iterator<Element> i = root.elementIterator("IDOC"); i.hasNext(); ) {
				Element e = i.next();
				System.out.println(e.attributeValue("BEGIN"));
			}
			

	        Node node = document.selectSingleNode("//ZAWZ01/IDOC/ZAWZ1STA01/ZAWZ1HDR01/REJESTRATOR");

	        System.out.println(node.getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
