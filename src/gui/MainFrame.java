package gui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import controller.Listener;

public class MainFrame extends JFrame
{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton btnChooseDirCPR;
    private JButton btnChooseDirDLL;
    private JList list1;
    private JList list2;


    public void initGUI() throws IOException
    {
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setTitle("Cubase Project Administration Tool");
        setResizable(false);
        Listener listener = new Listener();

        // ---------------------------------------------------
        // Panels:
        initGUIPanels();

        // ---------------------------------------------------
        // Buttons:
        initGUIButtons(listener);

        // ---------------------------------------------------
        // End of constructor
        setVisible(true);
    }


    private void initGUIPanels()
    {

    }

    private void initGUIButtons(Listener listener)
    {

    }

}



