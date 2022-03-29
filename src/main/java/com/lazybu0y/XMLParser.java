package com.lazybu0y;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLParser extends DefaultHandler {
    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        //super.startDocument();
        System.out.println("Start Document");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        currentValue.setLength(0);
        System.out.printf("Start Element : %s%n", qName);
        if (qName.equalsIgnoreCase("staff")) {
            // get tag's attribute by name
            String id = attributes.getValue("id");
            System.out.printf("Staff id : %s%n", id);
        }

        if (qName.equalsIgnoreCase("salary")) {
            // get tag's attribute by index, 0 = first attribute
            String currency = attributes.getValue(0);
            System.out.printf("Currency :%s%n", currency);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //super.endElement(uri, localName, qName);
        System.out.printf("End Element : %s%n", qName);

        if (qName.equalsIgnoreCase("name")) {
            System.out.printf("Name : %s%n", currentValue.toString());
        }

        if (qName.equalsIgnoreCase("role")) {
            System.out.printf("Role : %s%n", currentValue.toString());
        }

        if (qName.equalsIgnoreCase("salary")) {
            System.out.printf("Salary : %s%n", currentValue.toString());
        }

        if (qName.equalsIgnoreCase("bio")) {
            System.out.printf("Bio : %s%n", currentValue.toString());
        }
    }

    @Override
    public void endDocument() throws SAXException {
        //super.endDocument();
        System.out.println("End Document");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // super.characters(ch, start, length);
        currentValue.append(ch, start, length);
    }

}
