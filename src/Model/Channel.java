package Model;

import DATA_IO.XMLScheduleParser;
import org.w3c.dom.NodeList;

import java.awt.*;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class Channel {
    private int ID;
    private String channelName;
    private String scheduleURL;
    private NodeList nodeList;
    private Image image;

    public Channel(int ID, String channelName, String scheduleURL) {
        this.ID = ID;
        this.channelName = channelName;
        this.scheduleURL = scheduleURL;
        this.image = image;
    }

    public Channel getChannel() {
        return this;
    }

    public void setChannelID(int ID) {
        this.ID = ID;
    }

    public int getChannelID() {
        return this.ID;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setScheduleURL(String scheduleURL) {
        this.scheduleURL = scheduleURL;
    }

    public String getScheduleURL() {
        return this.scheduleURL;
    }

    public void parseSchedule() {
        XMLScheduleParser scheduleParser = new XMLScheduleParser(getScheduleURL());
        this.nodeList = scheduleParser.scheduleParser();
    }

    public NodeList getNodeList() {
        return this.nodeList;
    }
}
