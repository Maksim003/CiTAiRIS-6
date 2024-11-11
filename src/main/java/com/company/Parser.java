package com.company;

import com.company.Creators.DrinkCreator;
import com.company.Creators.FoodCreator;
import com.company.Interfaces.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private static Parser instance;
    Document document;
    Node node;

    private Parser() {

    }

    public static Parser getInstance() {
        if (instance == null) {
            instance = new Parser();
        }
        return instance;
    }

    public void create() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setIgnoringComments(true);
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse("D:\\Java\\CiTAiRIS-4\\menu.xml");
            node = document.getDocumentElement();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Dish> getBreakfast(ArrayList<Dish> breakfast) {
        if ("menu".equals(node.getNodeName())) {
            for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling()) {
                if (n.getNodeName().equalsIgnoreCase("breakfast_menu")) {
                    getMenu(n, breakfast);
                }
            }
        }
        return breakfast;
    }

    public ArrayList<Dish> getLunch(ArrayList<Dish> breakfast) {
        if ("menu".equals(node.getNodeName())) {
            for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling()) {
                if (n.getNodeName().equalsIgnoreCase("lunch_menu")) {
                    getMenu(n, breakfast);
                }
            }
        }
        return breakfast;
    }

    public ArrayList<Dish> getDinner(ArrayList<Dish> breakfast) {
        if ("menu".equals(node.getNodeName())) {
            for (Node n = node.getFirstChild(); n != null; n = n.getNextSibling()) {
                if (n.getNodeName().equalsIgnoreCase("dinner_menu")) {
                    getMenu(n, breakfast);
                }
            }
        }
        return breakfast;
    }

    public void getMenuCategories(Node n, Dish dish, ArrayList<Dish> array) {
        for (Node n1 = n.getFirstChild(); n1 != null; n1 = n1.getNextSibling()) {
            switch (n1.getNodeName()) {
                case "name":
                    dish.setName(n1.getTextContent());
                    break;
                case "price":
                    dish.setPrice(n1.getTextContent());
                    break;
                case "description":
                    dish.setDescription(n1.getTextContent());
                    break;
                case "calories":
                    dish.setCalories(n1.getTextContent());
                    break;
            }
        }
        array.add(dish);
    }

    public void getMenu(Node n, ArrayList<Dish> array) {
        for (Node n1 = n.getFirstChild(); n1 != null; n1 = n1.getNextSibling()) {
            Dish dish = new Dish();
            switch (n1.getNodeName()) {
                case "food":
                    dish.setProduct(getProductByType("Food"));
                    getMenuCategories(n1, dish, array);
                    break;
                case "drink":
                    dish.setProduct(getProductByType("Drink"));
                    getMenuCategories(n1, dish, array);
                    break;
            }
        }
    }

    public static Product getProductByType(String type) {
        switch (type) {
            case "Food":
                return new FoodCreator().createProduct();
            case "Drink":
                return new DrinkCreator().createProduct();
            default:
                throw new RuntimeException();
        }
    }
}