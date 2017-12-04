package DATA_IO;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by per-joelsompio on 15/03/17.
 */
public class XMLScheduleParser {
    private NodeList nodeList;
    private String scheduleURL;

    public XMLScheduleParser(String schedule) {
        scheduleURL = schedule;
    }

    public NodeList scheduleParser() {
        XMLread scheduleParse = new XMLread(scheduleURL);
        nodeList = scheduleParse.doc.getElementsByTagName("scheduledepisode");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println(i + "in scheduleparser");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println(element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("starttimeutc").item(0).getTextContent());
                System.out.println(element.getElementsByTagName("endtimeutc").item(0).getTextContent());
            }
        }
        return this.nodeList;
    }

}
