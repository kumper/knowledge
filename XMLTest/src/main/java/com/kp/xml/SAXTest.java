package com.kp.xml;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * SAX to odczyt dokumentów XML na podstawie ZDARZEŃ. Definiujemy co ma się stać na początku/końcu dokumentu/elementu
 * 
 * @author ParzychK
 */
public class SAXTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();

			reader.setContentHandler(new ContentHandler() {
				
				StringBuilder sb; //do zebrania zwykłych tekstów z poszczególnych Elementów

				public void startPrefixMapping(String arg0, String arg1) throws SAXException {
//					System.out.println("Start prefix mapping: " + arg0 + ", " + arg1);
				}

				public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
//					//Odczyt atrybutów
//					for (int i = 0; i < arg3.getLength(); i++) {
//						System.out.println(arg3.getType(i));
//						System.out.println(arg3.getValue(i));
//					}
					
					sb = new StringBuilder();
				}

				public void startDocument() throws SAXException {
//					System.out.println("Started document");
				}

				public void skippedEntity(String arg0) throws SAXException {
//					System.out.println("Skipped Entity: " + arg0);
				}

				public void setDocumentLocator(Locator arg0) {
					// nothing
				}

				public void processingInstruction(String arg0, String arg1) throws SAXException {
//					System.out.println("Processing instruction: " + arg0 + ", " + arg1);
				}

				public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {
					// nothing
				}

				public void endPrefixMapping(String arg0) throws SAXException {
//					System.out.println("End prefix mapping: " + arg0);
				}

				public void endElement(String arg0, String arg1, String arg2) throws SAXException {
//					System.out.println("Ended element: " + arg0 + ", " + arg1 + ", " + arg2);

					//Ustawienie flagi by odczytać kolejną zawartość
					if ("DOCNUM".equals(arg1)) {
						System.out.println("IDoc: " + sb.toString());
					}
					if ("REJESTRATOR".equals(arg1)) {
						System.out.println("Rejestrator: " + sb.toString());
					}
					if ("EBELN".equals(arg1)) {
						System.out.println("Zamówienie: " + sb.toString());
					}
					if ("TRANID".equals(arg1)) {
						System.out.println("Rejestracja: " + sb.toString());
					}
				}

				public void endDocument() throws SAXException {
//					System.out.println("Ended document");
				}

				public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
					sb.append(arg0, arg1, arg2);
				}
			});

			reader.parse("file.xml");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
