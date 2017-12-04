package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class TablePanel extends JScrollPane {
    JTable table;
    JScrollPane scollPane;
    private DefaultTableModel defaultTable;

    public TablePanel() {
        String colNames[] = {"Program", "Start", "Slut"};
        Object[][] rows = {};
        defaultTable = new DefaultTableModel(rows, colNames);
        final JTable table = new JTable(defaultTable);
        //table = new JTable(40,3);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(250, 250));
        table.setFillsViewportHeight(true);
    }
}
