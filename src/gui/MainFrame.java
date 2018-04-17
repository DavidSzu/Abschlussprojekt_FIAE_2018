package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import controller.Listener;

/**
 * Created by DSzustkowski on 27.03.18.
 */

public class MainFrame extends JFrame
{
    private JTabbedPane tabbedPane;
    private JPanel contentPane;
    private JButton btnChooseDirCPR;
    private JButton btnChooseDirDLL;
    private JPanel panelCubase;
    private JPanel panelPlugIns;
    private JList fileList;
    private Path path;
    private FileFilter filter = new FileNameExtensionFilter("Cubase or PlugIn Files", "cpr", "dll");
    private JFileChooser chooser;


    public void initGUI()
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

// -----------------------------------------------------------------------------
    public void addFileList(ArrayList<File> filesListed, String extension)
    {
        fileList = new JList(filesListed.toArray());
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(fileList);
        scrollPane.setBounds(0, 0, 564, 439);
        if (extension == "cpr")
        {
            panelCubase.add(scrollPane);
        }
        else if (extension == "dll")
        {
            panelPlugIns.add(scrollPane);
        }
        scrollPane.setViewportView(fileList);
    }

// -----------------------------------------------------------------------------
    public Path chooseDirectory()
    {
        path = null;
        chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(this);
        System.out.println("current Directory:" + chooser.getCurrentDirectory());

        if (chooser.getCurrentDirectory().isDirectory())
        {
            path = Paths.get(chooser.getCurrentDirectory().getAbsolutePath());
            return path;
        }
        else if (chooser.getCurrentDirectory().isFile())
        {
            path = Paths.get(chooser.getSelectedFile().getPath());
            return path;
        }
        return path;
    }

// -----------------------------------------------------------------------------

    public JButton getBtnChooseDirCPR()
    {
        return btnChooseDirCPR;
    }

    public JButton getBtnChooseDirDLL()
    {
        return btnChooseDirDLL;
    }
}



