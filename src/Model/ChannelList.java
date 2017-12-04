package Model;

import java.util.ArrayList;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class ChannelList {
    public ArrayList<Channel> channelList;

    public ChannelList() {
        channelList = new ArrayList<>();
    }

    public ArrayList getChannelList() {
        return this.channelList;
    }
}
