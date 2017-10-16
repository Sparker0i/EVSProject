package edu.amrita.theenvironment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.app.App;
import edu.amrita.theenvironment.blog1.Blog1Parser;
import edu.amrita.theenvironment.blog2.Blog2Parser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.init();
        new Blog2Parser(this).run();
    }
}
