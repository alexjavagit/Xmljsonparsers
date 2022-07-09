package task3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {

    public static void main(String[] args) {
        try {
            String request = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(request);

            Element root = document.getDocumentElement();
            System.out.println("Корневой элемент: " + root.getNodeName());
            System.out.println("----------------------");

            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.print((i+1) + ": ");

                    System.out.print(element.getElementsByTagName("exchangerate").item(0).getAttributes().getNamedItem("ccy") + "  ");
                    System.out.print(element.getElementsByTagName("exchangerate").item(0).getAttributes().getNamedItem("base_ccy") + "  ");
                    System.out.print(element.getElementsByTagName("exchangerate").item(0).getAttributes().getNamedItem("buy") + "  ");
                    System.out.println(element.getElementsByTagName("exchangerate").item(0).getAttributes().getNamedItem("sale") + "  ");
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}