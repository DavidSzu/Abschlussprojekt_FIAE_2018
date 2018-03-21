package model;

import gui.MainFrame;
import main.Main;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by DSzustkowski on 27.03.18.
 */
public class FileHandler
{

    MainFrame mf = Main.getMf();
    FileFilter filter = new FileNameExtensionFilter("Cubase Files", "");


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
}
