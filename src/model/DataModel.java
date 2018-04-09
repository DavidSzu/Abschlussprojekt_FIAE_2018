package model;


import java.io.File;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


/**
 * Created by DSzustkowski on 27.03.18.
 */
public class DataModel
{
    private ArrayList<File> fileListCPR = new ArrayList<>();
    private ArrayList<File> fileListDLL = new ArrayList<>();
    private Path path;

// -----------------------------------------------------------------------------
    public void collectionToArrayList(Collection fileCollection, String extension)
    {
        fileCollection = new HashSet<File>();
        ArrayList<File> fileList = new ArrayList<File>(fileCollection);

        if (extension == "cpr")
        {
            this.fileListCPR = fileList;
        }
        else
        {
            this.fileListDLL = fileList;

        }
    }

// -----------------------------------------------------------------------------
    public ArrayList<File> getFileListCPR()
    {
        return fileListCPR;
    }

    public void setFileListCPR(ArrayList<File> fileListCPR)
    {
        this.fileListCPR = fileListCPR;
    }

    public ArrayList<File> getFileListDLL()
    {
        return fileListDLL;
    }

    public void setFileListDLL(ArrayList<File> fileListDLL)
    {
        this.fileListDLL = fileListDLL;
    }

    public Path getPath()
    {
        return path;
    }

    public void setPath(Path path)
    {
        this.path = path;
    }

}
