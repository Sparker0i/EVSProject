package edu.amrita.theenvironment.blog1;

import android.content.Context;
import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import edu.amrita.theenvironment.utils.Constants;

public class Blog1Parser {

    private static Document document;
    private static Context context;

    public Blog1Parser(Context context) {
        Blog1Parser.context = context;
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
                document = Jsoup.connect(Constants.blog1).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().indexOf("<article id="),
                    document.html().indexOf("<nav role=\"navigation\" id=\"nav-below\" class=\"paging-navigation\">")));
            //System.out.println(document);
            Card1Maker.makeCards(context , document);
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
