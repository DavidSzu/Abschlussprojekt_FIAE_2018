package main;

import model.DataModel;
import gui.MainFrame;

import java.io.IOException;

/**
 * Created by DSzustkowski on 27.03.18.
 */

public class Main
{
    private static MainFrame mf;
    private static DataModel dataModel;


    public static void main(String[] args)
    {
        dataModel = new DataModel();
        mf = new MainFrame();
        mf.initGUI();

    }

// -----------------------------------------------------------------------------
    public static MainFrame getMf()
    {
        return mf;
    }

// -----------------------------------------------------------------------------
    public static DataModel getDataModel()
    {
        return dataModel;
    }
}
