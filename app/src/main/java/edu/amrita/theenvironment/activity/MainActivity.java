package edu.amrita.theenvironment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.blogparser.Blog2Parser;
import edu.amrita.theenvironment.blogparser.Blog3Parser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Blog3Parser.run();
    }
}
