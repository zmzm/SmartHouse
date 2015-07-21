package by.intexsoft;

import by.intexsoft.manager.Manager;
import by.intexsoft.parser.Parser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by Admin on 19.07.2015.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Parser handler = new Parser();
        parser.parse(new File("D:\\Неизвестная папка\\Лабораторные\\Java\\SmartHouse\\data.xml"), handler);

        Manager manager = new Manager();
        Thread mainThread = new Thread(manager);
        mainThread.start();
    }
}
