package model;

import main.Main;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by DSzustkowski on 27.03.18.
 */
public class FileHandler
{
    private DataModel dataModel = Main.getDataModel();

// -----------------------------------------------------------------------------
    public void listFiles(String directoryName) throws IOException
    {
        File dir = new File(directoryName);
        String [] extensions = new String[] {"cpr", "dll"};
        System.out.println("Getting all .cpr and .dll files in " + dir.getCanonicalPath() + " including those in subdirectories");
        List<File> files = (List<File>) FileUtils.listFiles(dir, extensions, true);
        ArrayList<File> filesArray = new ArrayList<>(files);

        for (int i = 0; i < filesArray.size(); i++ )
        {
            String ext = FilenameUtils.getExtension(filesArray.get(i).toString());
            if (ext.equals("cpr") )
            {
                dataModel.getFileListCPR().add(filesArray.get(i));
            }
            else if (ext.equals("dll"))
            {
                dataModel.getFileListDLL().add(filesArray.get(i));
            }
            else return;
            System.out.println("File: " + filesArray.get(i).getCanonicalPath());
        }
    }

// -----------------------------------------------------------------------------
    private String getFileModTime(File file) throws IOException
    {
        Path path = Paths.get(file.getAbsolutePath());
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Last modified: " + attributes.lastModifiedTime());

        FileTime modDate = attributes.lastModifiedTime();
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy/hh");
        String dateLastModified = df.format(modDate.toMillis());

        return dateLastModified;
    }

// -----------------------------------------------------------------------------
    public void addModifiedTimeToList(ArrayList fileList, String ext) throws IOException
    {
        for (int i = 0; i < fileList.size(); i++ )
        {
            String fileModTime = getFileModTime((File) fileList.get(i));
            if (ext.equals("cpr"))
            {
                dataModel.getModTimeListCPR().add(fileModTime);
            }
            else if (ext.equals("dll"))
            {
                dataModel.getModTimeListDLL().add(fileModTime);
            }
        }
    }
}
