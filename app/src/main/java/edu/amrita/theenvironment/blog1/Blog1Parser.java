package edu.amrita.theenvironment.blog1;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import edu.amrita.theenvironment.utils.Constants;

public class Blog1Parser {

    private static Document document;

    public Blog1Parser() {}

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
                document = Jsoup.connect(Constants.blog1).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("recent-posts-3")+106,
                    document.html().indexOf("categories-2")-23));
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
