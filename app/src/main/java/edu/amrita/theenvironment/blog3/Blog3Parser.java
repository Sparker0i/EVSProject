package edu.amrita.theenvironment.blog3;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import android.content.Context;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import edu.amrita.theenvironment.blog1.Blog1Parser;
import edu.amrita.theenvironment.utils.Constants;

public class Blog3Parser {

    private static Document document;
    private static Context context;

    public static void run(Context context) {
        Blog3Parser.context = context;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Blog3Parser.Task().execute().get();
                }
                catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    private static class Task extends AsyncTask<Void , Void , Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                document = Jsoup.connect(Constants.blog3).get();
            }
            catch (IOException iex) {
                iex.printStackTrace();
            }
            document = Jsoup.parse(document.html().substring(document.html().lastIndexOf("stream-item-list")-9 , document.html().indexOf("<div id=\"pagination\"> ")));
            Card3Maker.makeCards(context , document);
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
