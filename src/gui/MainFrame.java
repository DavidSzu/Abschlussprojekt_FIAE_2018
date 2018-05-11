package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
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
    private JPanel panelPathCPR;
    private JPanel panelPathDLL;
    private JPanel panelModtimeCPR;
    private TextField tfPathCPR;
    private TextField tfPathDLL;
    private TextField tfModtimeCPR;
    private JList fileList;
    private Path path;
    private FileFilter filter = new FileNameExtensionFilter("Cubase or PlugIn Files", "cpr", "dll");
    private JFileChooser chooser;

    public void initGUI()
    {
        setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600); //+400, +100
        setTitle("Cubase Project Administration Tool");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0,0,0,0));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 964, 539);
        contentPane.add(tabbedPane);

        panelCubase = new JPanel();
        tabbedPane.addTab("Cubase", null, panelCubase, null);
        panelCubase.setLayout(null);

        panelPathCPR = new JPanel();
        panelPathCPR.setBounds(0,20,479,452);
        //panelPathCPR.setBackground(Color.GREEN);
        panelCubase.add(panelPathCPR);

        panelModtimeCPR = new JPanel();
        panelModtimeCPR.setBounds(480, 20, 479, 452);
        //panelModtimeCPR.setBackground(Color.RED);
        panelCubase.add(panelModtimeCPR);

        tfPathCPR = new TextField("Path");
        tfPathCPR.setBounds(0,0,479, 20);
        tfPathCPR.setEditable(false);
        panelCubase.add(tfPathCPR);

        tfModtimeCPR = new TextField("Last modified");
        tfModtimeCPR.setBounds(480,0,479, 20);
        tfModtimeCPR.setEditable(false);
        panelCubase.add(tfModtimeCPR);

        panelPlugIns = new JPanel();
        tabbedPane.addTab("PlugIns", null, panelPlugIns, null);
        panelPlugIns.setLayout(null);

        panelPathDLL = new JPanel();
        panelPathDLL.setBounds(0,20,962,452);
        //panelPathDLL.setBackground(Color.RED);
        panelPlugIns.add(panelPathDLL);

        tfPathDLL = new TextField("Path");
        tfPathDLL.setBounds(0,0,959, 20);
        tfPathDLL.setEditable(false);
        panelPlugIns.add(tfPathDLL);

        Listener listener = new Listener();

        btnChooseDirCPR = new JButton("Choose Directory");
        btnChooseDirCPR.setBounds(0, 472, 959, 23);
        btnChooseDirCPR.addActionListener(listener);
        panelCubase.add(btnChooseDirCPR);

        btnChooseDirDLL = new JButton("Choose Directory");
        btnChooseDirDLL.setBounds(0, 472, 959, 23);
        btnChooseDirDLL.addActionListener(listener);
        panelPlugIns.add(btnChooseDirDLL);

        setVisible(true);
    }

// -----------------------------------------------------------------------------
    private void addFileList(ArrayList<File> fileList, String extension)
    {
        this.fileList = new JList(fileList.toArray());
        this.fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(this.fileList);
        scrollPane.setBounds(0, 0, 482, 452); //482,452
        if (extension == "cpr")
        {
            getPanelPathCPR().add(scrollPane);
        }
        else if (extension == "dll")
        {
            getPanelPathDLL().add(scrollPane);
        }
        scrollPane.setViewportView(this.fileList);
    }

// -----------------------------------------------------------------------------
    private void addModTimeList(ArrayList<String> modTimeList, String extension)
    {
        fileList = new JList(modTimeList.toArray());
        fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(fileList);
        scrollPane.setBounds(0, 0, 482, 452); //482,452

        getPanelModtimeCPR().add(scrollPane);


        scrollPane.setViewportView(fileList);
    }

// -----------------------------------------------------------------------------
    public void addLists(ArrayList<File> fileList, ArrayList<String> modTimeList, String extension)
    {
        addFileList(fileList, extension);
        addModTimeList(modTimeList, extension);
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

    public JPanel getPanelPathCPR()
    {
        return panelPathCPR;
    }

    public JPanel getPanelPathDLL()
    {
        return panelPathDLL;
    }

    public JPanel getPanelModtimeCPR()
    {
        return panelModtimeCPR;
    }

    public JPanel getPanelModtimeDLL()
    {
        return panelModtimeDLL;
    }
}



