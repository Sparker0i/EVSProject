package edu.amrita.theenvironment.blog4;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import edu.amrita.theenvironment.utils.Constants;

public class Blog4Parser {

    private static Document document;

    public Blog4Parser() {}

    public static void run() {
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
                document = Jsoup.connect(Constants.blog4).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("<ul class=\"title-list__entries\">"),
                    document.html().indexOf("<section class=\"standard-listing-row-layout\">")-44));
            /*int idx = document.html().indexOf("Unaffiliated components</h2>");
            document = Jsoup.parse(document.html().substring(0 , idx + 28) + "<p></p>" + document.html().substring(idx + 28 , document.html().length()));*/
            System.out.println(document);
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
