package DATA_IO;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class XMLread {
    public Document doc;

    public XMLread(String URLString) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            dbf.setNamespaceAware(true);
            doc = dbf.newDocumentBuilder().parse(new URL(URLString).openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return this.doc;
    }
}
