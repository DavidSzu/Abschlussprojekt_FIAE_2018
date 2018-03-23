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

// -----------------------------------------------------------------------------
    public ArrayList<File> getFileListCPR()
    {
        return fileListCPR;
    }

    public ArrayList<File> getFileListDLL()
    {
        return fileListDLL;
    }
    public void setFileListCPR(ArrayList<File> fileListCPR)
    {
        this.fileListCPR = fileListCPR;
    }

    public void setFileListDLL(ArrayList<File> fileListDLL)
    {
        this.fileListDLL = fileListDLL;
    }
}
