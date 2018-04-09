package model;

import main.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import static org.apache.commons.io.FileUtils.listFiles;

/**
 * Created by DSzustkowski on 27.03.18.
 */
public class FileHandler
{
    private DataModel dataModel = Main.getDataModel();

    private File directory1;
    private File directory;
    private File[] fList1;
    Collection<File> fList;
    private ArrayList<File> filesListed;


// -----------------------------------------------------------------------------
public void listFiles(String directoryName, String[] extensions)
{

    directory = new File(directoryName);
    for (File file : fList = FileUtils.listFiles(directory, extensions, true))
    {
        if (file.isFile())
        {
            fList.add(file);
        }

        if (extensions[0] == "cpr")
        {
            dataModel.collectionToArrayList(fList, "cpr");
        }
        else
        {
            dataModel.collectionToArrayList(fList, "dll");
        }
    }
}

// -----------------------------------------------------------------------------
    public void listFiles1(String directoryName, String extension)
    {
        directory1 = new File (directoryName);
        fList1 = directory1.listFiles(new FileExtensionFilter("Cubase Files ", extension)
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
        for (File file : fList1)
        {
            if (file.isFile())
            {
                filesListed.add(file);
            }
            else if (file.isDirectory())
            {
                listFiles1(file.getAbsolutePath(), extension);
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

}
