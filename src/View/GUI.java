package View;

import Model.Channel;
import Model.ChannelList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by per-joelsompio on 14/03/17.
 */
public class GUI extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;

    private JFrame frame;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel middlePanel;
    private JTable table;
    private DefaultTableModel dtm;
    private JScrollPane scrollPane;

    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    public GUI(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        scrollPane = buildTable();

        leftPanel = buildLeftPanel();
        rightPanel = buildRightPanel();
        middlePanel = buildMiddlePanel();
        menuBar = buildMenuBar();


        leftPanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(menuBar, BorderLayout.NORTH);


    }

    private JScrollPane buildTable() {

        String colNames[] = {"Program", "Start", "Slut"};
        Object[][] rows = {};
        dtm = new DefaultTableModel(rows, colNames);
        final JTable table = new JTable(dtm);
        //table = new JTable(40,3);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(250, 250));
        table.setFillsViewportHeight(true);
        /*setLayout(new FlowLayout());

        String[] columnName = {"Name", "Time", "Things"};

        Object[][] data = {};

        table = new JTable(data, columnName);
        table.setPreferredScrollableViewportSize(new Dimension(250, 250));
        table.setFillsViewportHeight(true);*/

        return scrollPane;
    }

    private JPanel buildLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 300));
        leftPanel.setBackground(Color.YELLOW);
        leftPanel.setVisible(true);
        return leftPanel;
    }

    private JPanel buildRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLUE);
        rightPanel.setPreferredSize(new Dimension(300, 300));
        rightPanel.setVisible(true);
        return rightPanel;
    }

    private JPanel buildMiddlePanel() {
        middlePanel = new JPanel();
        middlePanel.setBackground(Color.CYAN);
        middlePanel.setPreferredSize(new Dimension(300, 300));
        return middlePanel;
    }

    private JMenuBar buildMenuBar() {
        //Create the menu bar.
        menuBar = new JMenuBar();

//Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

//a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

//a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

//a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

//Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);


        return menuBar;
    }

    public void uptabeTable(Channel channel) {

        for (int i = 0; i < channel.getNodeList().getLength(); i++) {
            dtm.addRow(new Object[]{channel.getNodeList().item(i)});
        }
        /*for(int i = 0; i < channelList.channelList.size(); i++) {
            dtm.addRow(new Object[]{channelList.channelList.get(i).getChannelName()});
            System.out.println(i);
        }*/
    }

}
