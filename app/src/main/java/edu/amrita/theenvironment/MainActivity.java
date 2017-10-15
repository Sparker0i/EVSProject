package edu.amrita.theenvironment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.amrita.theenvironment.blog1.Blog1Parser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Blog1Parser.run();
    }
}
