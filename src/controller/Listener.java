package controller;

import gui.MainFrame;
import main.Main;
import model.DataModel;
import model.FileHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

/**
 * Created by DSzustkowski on 27.03.18.
 */

public class Listener implements ActionListener
{
    private DataModel dataModel = Main.getDataModel();
    private MainFrame mainFrame = Main.getMf();
    private FileHandler fileHandler = new FileHandler();
    private String[] extensions = new String[2];


    public void actionPerformed(ActionEvent e)
    {
        extensions[0] = "cpr";
        extensions[1] = "dll";
        Object source = e.getSource();

        if (source == mainFrame.getBtnChooseDirCPR()|| source == mainFrame.getBtnChooseDirDLL())
        {
            chooseDirectory(extensions);
        }

    }

    private void chooseDirectory(String[] extension)
    {
        Path directoryName = mainFrame.chooseDirectory();
        fileHandler.listFiles(directoryName.toString(), extension);
        if (extension[0] == "cpr")
        {
            mainFrame.addFileList(dataModel.getFileListCPR());
        }
        else
            mainFrame.addFileList(dataModel.getFileListDLL());
    }

}
