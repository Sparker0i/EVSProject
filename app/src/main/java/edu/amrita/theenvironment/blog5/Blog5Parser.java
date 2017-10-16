package edu.amrita.theenvironment.blog5;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import edu.amrita.theenvironment.utils.Constants;

public class Blog5Parser {

    private static Document document;
    private static Context context;

    public Blog5Parser(Context context) {
        Blog5Parser.context = context;
    }

    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Task().doInBackground();
            }
        }).start();
    }

    private static class Task extends AsyncTask<Void , Void , Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                document = Jsoup.connect(Constants.blog5).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("<ul class=\"small-block-grid-1 medium-block-grid-2\">"),
                    document.html().indexOf("<div class=\"small-12 medium-5 large-4 columns\">")));
            /*int idx = document.html().indexOf("Unaffiliated components</h2>");
            document = Jsoup.parse(document.html().substring(0 , idx + 28) + "<p></p>" + document.html().substring(idx + 28 , document.html().length()));*/
            System.out.println(document);
            Card5Maker.makeCards(context , document);
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
