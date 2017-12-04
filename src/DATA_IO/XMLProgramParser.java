package DATA_IO;

import Model.Channel;
import Model.ChannelList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by per-joelsompio on 15/03/17.
 */
public class XMLProgramParser {
    private ChannelList channelList;
    private NodeList nodeList;
    private String URLString;

    public XMLProgramParser(String URL) {
        URLString = URL;

    }

    public void channelParser() {
        XMLread parse = new XMLread(URLString);
        this.channelList = new ChannelList();
        nodeList = parse.doc.getElementsByTagName("channel");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node newNode = nodeList.item(i);
            System.out.println(i + "in channelparser");
            if (newNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) newNode;

                int ID = Integer.parseInt(eElement.getAttribute("id"));
                String name = eElement.getAttribute("name");
                if (eElement.getElementsByTagName("scheduleurl").getLength() != 0) {
                    String scheduleURL = eElement.getElementsByTagName("scheduleurl").item(0).getTextContent();
                    Channel channel = new Channel(ID, name, scheduleURL);
                    channelList.channelList.add(channel);
                }
            }
        }
    }

    public ArrayList<Channel> getParsedChannelList() {
        return this.channelList.channelList;
    }

    public void clearArrayList() {
        this.channelList.channelList.clear();
    }

}
