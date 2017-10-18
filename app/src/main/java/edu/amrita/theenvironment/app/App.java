package edu.amrita.theenvironment.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import edu.amrita.theenvironment.activity.MainActivity;
import edu.amrita.theenvironment.blog1.Blog1Parser;
import edu.amrita.theenvironment.blog2.Blog2Parser;
import edu.amrita.theenvironment.blog5.Blog5Parser;
import edu.amrita.theenvironment.model.Model;

public class App extends Application {
    public static ArrayList<Model> cardlist;
    private static Context context;

    public void init() throws InterruptedException , ExecutionException{
        cardlist = new ArrayList<>();
        context = this;
        new Task().doInBackground();
    }

    private class Task extends AsyncTask<Void , Void , Void> {

        @Override
        protected Void doInBackground(Void... params) {
            ThreadGroup tg1 = new ThreadGroup("Group A");
            Thread t1 = new Thread(tg1 , new Runnable() {
                @Override
                public void run() {
                    System.out.println("T1 Start");
                    Blog1Parser.run();
                }
            });
            Thread t2 = new Thread(tg1 , new Runnable() {
                @Override
                public void run() {
                    System.out.println("T2 Start");
                    Blog2Parser.run();
                }
            });
            Thread t3 = new Thread(tg1 , new Runnable() {
                @Override
                public void run() {
                    System.out.println("T3 Start");
                    Blog5Parser.run();
                }
            });
            t1.start();
            t2.start();
            t3.start();
            try {
                t1.join();
                t2.join();
                t3.join();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            Intent intent = new Intent(App.this , MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return null;
        }
    }
}
