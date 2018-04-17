package controller;

import gui.MainFrame;
import main.Main;
import model.DataModel;
import model.FileHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by DSzustkowski on 27.03.18.
 */

public class Listener implements ActionListener
{
    private DataModel dataModel = Main.getDataModel();
    private MainFrame mainFrame = Main.getMf();
    private FileHandler fileHandler = new FileHandler();


    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source == mainFrame.getBtnChooseDirCPR()|| source == mainFrame.getBtnChooseDirDLL())
        {
            try
            {
                chooseDirectory();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }

    private void chooseDirectory() throws IOException
    {
        Path directoryName = mainFrame.chooseDirectory();
        fileHandler.listFiles(directoryName.toString());
        mainFrame.addFileList(dataModel.getFileListCPR(), "cpr");

    }

}
