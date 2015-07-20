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
        Integer[] array = handler.getData();

        Manager manager = new Manager(array[0], array[1], array[2], array[3]);
        manager.run();
    }
}
