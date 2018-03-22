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

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source == mainFrame.getBtnChooseDirCPR())
        {
            chooseDirectoryCPR();
        }

        if (source == mainFrame.getBtnChooseDirDLL())
        {
            chooseDirectoryDLL();
        }

    }

    private void chooseDirectoryCPR()
    {
        FileHandler fileHandler = new FileHandler();
        Path directoryName = fileHandler.chooseDirectory();
        fileHandler.listCPRFiles(directoryName.toString());
        mainFrame.addFileListCPR(dataModel.getFileListCPR());
    }

    private void chooseDirectoryDLL()
    {
        FileHandler fileHandler = new FileHandler();
        Path directoryName = fileHandler.chooseDirectory();
        fileHandler.listDLLFiles(directoryName.toString());
        mainFrame.addFileListDLL(dataModel.getFileListCPR());
    }
}
