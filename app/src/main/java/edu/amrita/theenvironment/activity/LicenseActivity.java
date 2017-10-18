package edu.amrita.theenvironment.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.utils.Constants;

public class LicenseActivity extends AppCompatActivity
{
    int libID;
    Toolbar toolbar;
    private String license;
    private String library;
    private String link;
    TextView licText;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        licText = findViewById(R.id.license);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);
        libID = getIntent().getExtras().getInt(Constants.LIBRARY_ID);

        switch (libID)
        {
            case 2:
            {
                library = getString(R.string.lib_2);
                license = getString(R.string.lib_2_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_2_link);
                break;
            }
            case 3:
            {
                library = getString(R.string.lib_3);
                license = getString(R.string.lib_3_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_3_link);
                break;
            }
            case 4:
            {
                library = getString(R.string.lib_4);
                license = getString(R.string.lib_4_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_4_link);
                break;
            }
            case 6:
            {
                library = getString(R.string.lib_6);
                license = getString(R.string.lib_6_license) + getString(R.string.mit_license);
                link = getString(R.string.lib_6_link);
                break;
            }
            case 9:
            {
                library = getString(R.string.lib_9);
                license = getString(R.string.lib_9_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_9_link);
                break;
            }
            case 10:
            {
                library = getString(R.string.lib_10);
                license = getString(R.string.lib_10_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_10_link);
                break;
            }
            case 11 :
            {
                library = getString(R.string.lib_11);
                license = getString(R.string.lib_11_license) + getString(R.string.apache_license);
                link = getString(R.string.lib_11_link);
                break;
            }
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(library);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        fab.setImageDrawable(new IconicsDrawable(this)
                            .icon(MaterialDesignIconic.Icon.gmi_github)
                            .color(Color.WHITE));
        licText.setText(Html.fromHtml(license));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
