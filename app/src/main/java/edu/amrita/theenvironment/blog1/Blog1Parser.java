package edu.amrita.theenvironment.blog1;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.amrita.theenvironment.utils.Constants;

public class Blog1Parser {

    private static Document document;

    public static void run() {
        try {
            new Task().execute().get();
        }
        catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    private static class Task extends AsyncTask<Void , Void , Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                document = Jsoup.connect(Constants.blog1).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("<article id="),
                    document.html().indexOf("<nav role=\"navigation\" id=\"nav-below\" class=\"paging-navigation\">")));
            Card1Maker.makeCards(document);
            return null;
        }
    }
}
