package edu.amrita.theenvironment.blog2;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.amrita.theenvironment.blog1.Blog1Parser;
import edu.amrita.theenvironment.utils.Constants;

public class Blog2Parser {

    private static Document document;

    public static void run() {
        try {
            new Blog2Parser.Task().execute().get();
        }
        catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }

    private static class Task extends AsyncTask<Void , Void , Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                document = Jsoup.connect(Constants.blog2).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("<main id=\"main\" class=\"site-main\" role=\"main\">"),
                    document.html().indexOf("<!-- .site-main -->")));
            Card2Maker.makeCards(document);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            /*Intent intent = new Intent(Global.this , MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
        }
    }
}
