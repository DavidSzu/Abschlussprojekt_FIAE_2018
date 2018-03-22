package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import controller.Listener;

public class MainFrame extends JFrame
{
    private JTabbedPane tabbedPane;
    private JPanel contentPane;
    private JButton btnChooseDirCPR;
    private JButton btnChooseDirDLL;
    private JPanel panelCubase;
    private JPanel panelPlugIns;
    private JList<File> listCPR;
    private JList<File> listDLL;

    public void initGUI() throws IOException
    {
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        setTitle("Cubase Project Administration Tool");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 564, 439);
        contentPane.add(tabbedPane);

        panelCubase = new JPanel();
        tabbedPane.addTab("Cubase", null, panelCubase, null);
        panelCubase.setLayout(null);

        panelPlugIns = new JPanel();
        tabbedPane.addTab("PlugIns", null, panelPlugIns, null);
        panelPlugIns.setLayout(null);

        Listener listener = new Listener();

        btnChooseDirCPR = new JButton("Choose Directory");
        btnChooseDirCPR.setBounds(0, 377, 549, 23);
        btnChooseDirCPR.addActionListener(listener);
        panelCubase.add(btnChooseDirCPR);

        btnChooseDirDLL = new JButton("Choose Directory");
        btnChooseDirDLL.setBounds(0, 377, 549, 23);
        btnChooseDirDLL.addActionListener(listener);
        panelPlugIns.add(btnChooseDirDLL);


        setVisible(true);
    }

    public void addFileListCPR (ArrayList<File> filesListed)
    {
        listCPR = new JList(filesListed.toArray());
        listCPR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listCPR);
        scrollPane.setBounds(0, 0, 564, 439);
        panelCubase.add(scrollPane);
        scrollPane.setViewportView(listCPR);
    }

    public void addFileListDLL(ArrayList<File> filesListed)
    {
        listDLL = new JList(filesListed.toArray());
        listDLL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listDLL);
        scrollPane.setBounds(0, 0, 564, 439);
        panelPlugIns.add(scrollPane);
        scrollPane.setViewportView(listDLL);
    }

    public JButton getBtnChooseDirCPR()
    {
        return btnChooseDirCPR;
    }

    public JButton getBtnChooseDirDLL()
    {
        return btnChooseDirDLL;
    }
}



