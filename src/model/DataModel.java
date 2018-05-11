package model;


import java.io.File;
import java.util.ArrayList;

/**
 * Created by DSzustkowski on 27.03.18.
 */
public class DataModel
{
    private ArrayList<File> fileListCPR = new ArrayList<>();
    private ArrayList<File> fileListDLL = new ArrayList<>();
    private ArrayList<String>   modTimeListCPR = new ArrayList<>();

// -----------------------------------------------------------------------------
    public void addCPRFileToList(File cprFile)
    {
        fileListCPR.add(cprFile);
    }

// -----------------------------------------------------------------------------
    public void addDLLFileToList(File dllFile)
    {
        fileListDLL.add(dllFile);
    }

// -----------------------------------------------------------------------------
    public void addToModTimeList (String modTime)
    {
        modTimeListCPR.add(modTime);
    }

// -----------------------------------------------------------------------------
    public ArrayList<File> getFileListCPR()
    {
        return fileListCPR;
    }
    public ArrayList<String> getModTimeListCPR()
    {
        return modTimeListCPR;
    }
}
