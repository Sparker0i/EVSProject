package edu.amrita.theenvironment.app;

import android.app.Application;

import java.util.ArrayList;

import edu.amrita.theenvironment.model.Model;

public class App extends Application {
    public static ArrayList<Model> cardlist;

    public static void init() {
        cardlist = new ArrayList<>();
    }
}
