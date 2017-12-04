import DATA_IO.XMLProgramParser;
import DATA_IO.XMLScheduleParser;
import DATA_IO.XMLread;
import Model.Channel;
import Model.ChannelList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.XMLReader;

import javax.swing.*;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class RadioInfo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View.GUI gui = new View.GUI("RadioInfo");
                ChannelList channelList = new ChannelList();


                XMLProgramParser programParser = new XMLProgramParser("http://api.sr.se/api/v2/channels");
                programParser.channelParser();
                for (int i = 0; i < programParser.getParsedChannelList().size(); i++) {
                    channelList.channelList.add(programParser.getParsedChannelList().get(i));
                    System.out.println(programParser.getParsedChannelList().get(i).getChannelName());
                    System.out.println("");
                    System.out.println(channelList.channelList.get(i).getChannelName());
                    System.out.println("");

                    channelList.channelList.get(i).parseSchedule();
                }
                //making sure there arent 2 of the same arraylist somewhere in the memory
                programParser.getParsedChannelList().clear();
                gui.uptabeTable(channelList.channelList.get(0));
            }
        });

        //NodeList newNode = parser.doc.getElementsByTagName("channel");
        /*for(int i = 0; i < newNode.getLength(); i++) {
            Node nNode = newNode.item(i);

            if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                int ID = Integer.parseInt(eElement.getAttribute("id"));
                String name = eElement.getAttribute("name");
                if(eElement.getElementsByTagName("scheduleurl").getLength() != 0) {
                    String scheduleURL = eElement.getElementsByTagName("scheduleurl").item(0).getTextContent();
                    Channel channel = new Channel(ID, name, scheduleURL);
                    channelList.channelList.add(channel);
                }
            }
        }

        /*ChannelList channelList = new ChannelList();


        XMLProgramParser programParser = new XMLProgramParser("http://api.sr.se/api/v2/channels");
        programParser.channelParser();
        for(int i = 0; i < programParser.getParsedChannelList().size(); i++) {
            channelList.channelList.add(programParser.getParsedChannelList().get(i));
            System.out.println(programParser.getParsedChannelList().get(i).getChannelName());
            System.out.println("");
            System.out.println(channelList.channelList.get(i).getChannelName());
            System.out.println("");

            //making sure there arent 2 of the same arraylist somewhere in the memory
            programParser.getParsedChannelList().clear();

            channelList.channelList.get(i).parseSchedule();
        }*/
    }
}
