package model;

import gui.MainFrame;
import main.Main;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by DSzustkowski on 27.03.18.
 */
public class FileHandler
{

    MainFrame mf = Main.getMf();
    DataModel dataModel = Main.getDataModel();
    FileFilter filter = new FileNameExtensionFilter("Cubase or PlugIn Files", "cpr", "dll");


    public Path chooseDirectory()
    {
        Path path = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(mf);
        System.out.println("current Directory:" + chooser.getCurrentDirectory());

        if (chooser.getCurrentDirectory().isDirectory())
        {
            path = Paths.get(chooser.getCurrentDirectory().getAbsolutePath());
            return path;
        } else if (chooser.getCurrentDirectory().isFile())
        {
            path = Paths.get(chooser.getSelectedFile().getPath());
            return path;
        }
        return path;
    }

// -----------------------------------------------------------------------------
    public void listCPRFiles(String directoryName)
    {
        File directory = new File (directoryName);
        File[] fList = directory.listFiles(new ExtensionFileFilter ("Cubase Files ", "cpr")
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if (name.toLowerCase().endsWith("cpr"))
                {
                    return name.toLowerCase().endsWith("cpr");
                }
                else return false;
            }
        });

        ArrayList<File> filesListed = dataModel.getFileListCPR();

        for (File file : fList)
        {
            if (file.isFile())
            {
                filesListed.add(file);
            }
            else if (file.isDirectory())
            {
                listCPRFiles(file.getAbsolutePath());
            }
        }
        System.out.println(dataModel.getFileListCPR() + "dataModel.getFileListCPR");
    }

    // -----------------------------------------------------------------------------
    public void listDLLFiles(String directoryName)
    {
        File directory = new File (directoryName);
        File[] fList = directory.listFiles(new ExtensionFileFilter ("PlugIn Files",  "dll")
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if (name.toLowerCase().endsWith("dll"))
                {
                    return name.toLowerCase().endsWith("dll");
                }
                else return false;
            }
        });

        ArrayList<File> filesListed = dataModel.getFileListDLL();

        for (File file : fList)
        {
            if (file.isFile())
            {
                filesListed.add(file);
            }
            else if (file.isDirectory())
            {
                listCPRFiles(file.getAbsolutePath());
            }
        }
        System.out.println(dataModel.getFileListDLL() + "dataModel.getFileListDLL");
    }
}
