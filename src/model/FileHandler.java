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

    private MainFrame mf = Main.getMf();
    private DataModel dataModel = Main.getDataModel();

    private File directory;
    private File[] fList;
    private ArrayList<File> filesListed;


// -----------------------------------------------------------------------------
    public void listFiles(String directoryName, String extension)
    {
        directory = new File (directoryName);
        fList = directory.listFiles(new FileExtensionFilter("Cubase Files ", extension)
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if (name.toLowerCase().endsWith(extension))
                {
                    return name.toLowerCase().endsWith(extension);
                }
                else return false;
            }
        });

        filesListed = new ArrayList();
        for (File file : fList)
        {
            if (file.isFile())
            {
                filesListed.add(file);
            }
            else if (file.isDirectory())
            {
                listFiles(file.getAbsolutePath(), extension);
            }
        }

        if (extension == "cpr")
        {
            dataModel.setFileListCPR(filesListed);
        }
        else
            dataModel.setFileListDLL(filesListed);


        System.out.println(dataModel.getFileListCPR() + "dataModel.getFileListCPR");
    }

// -----------------------------------------------------------------------------
    public void walkCPR(String directoryName)
    {
        directory = new File(directoryName);
        fList = directory.listFiles(new FileExtensionFilter("Cubase Files ", "cpr"));

        if (fList == null) return;

        ArrayList<File> filesListed = dataModel.getFileListCPR();
        for (File file : fList)
        {
            if (file.isDirectory())
            {
                walkCPR(file.getAbsolutePath());
                System.out.println("Dir:" + file.getAbsoluteFile());
            }
            else
            {
                filesListed.add(file);
                System.out.println("File:" + file.getAbsoluteFile());
            }
        }
    }
}
