package MnT;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import javafx.collections.ObservableList;

public class XMLParser {

    public static void load(ObservableList<Person> data){
        try{
            File file = new File("MnT/data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("person");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node nNode = list.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String gender = eElement.getElementsByTagName("gender").item(0).getTextContent();
                    String role = eElement.getElementsByTagName("role").item(0).getTextContent();

                    Person person = new Person(name, id, gender, role);
                    data.add(person);}}
        }catch (Exception e){
            e.printStackTrace();}}}