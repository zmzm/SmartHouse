package by.intexsoft.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Admin on 19.07.2015.
 */
public class Parser extends DefaultHandler {
    static ArrayList<Integer> data;
    String thisElement = "";

    public static Integer[] getData() {
        return data.toArray(new Integer[data.size()]);
    }

    @Override
    public void startDocument() throws SAXException {
        data = new ArrayList<Integer>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("starttime")) {
            data.add(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("endtime")) {
            data.add(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("maxtemp")) {
            data.add(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("mintemp")) {
            data.add(Integer.parseInt(new String(ch, start, length)));
        }
    }

}
