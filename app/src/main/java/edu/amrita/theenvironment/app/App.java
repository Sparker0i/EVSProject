package edu.amrita.theenvironment.app;

import android.app.Application;

import java.util.ArrayList;

import edu.amrita.theenvironment.blog1.Blog1Parser;
import edu.amrita.theenvironment.blog2.Blog2Parser;
import edu.amrita.theenvironment.blog3.Blog3Parser;
import edu.amrita.theenvironment.blog5.Blog5Parser;
import edu.amrita.theenvironment.model.Model;

public class App extends Application {
    public static ArrayList<Model> cardlist;

    public void init() {
        cardlist = new ArrayList<>();
        Blog1Parser.run(this);
        Blog2Parser.run(this);
        Blog3Parser.run(this);
        Blog5Parser.run(this);
    }
}
