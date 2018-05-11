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
    private ArrayList<String>   modTimeListCPR = new ArrayList<>();

    private Path path;

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

    public ArrayList<String> getModTimeListCPR()
    {
        return modTimeListCPR;
    }

    public void setModTimeListCPR(ArrayList<String> modTimeListCPR)
    {
        this.modTimeListCPR = modTimeListCPR;
    }

}
