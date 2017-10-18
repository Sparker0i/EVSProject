package edu.amrita.theenvironment.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.AbsListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.cards.AboutCard;
import edu.amrita.theenvironment.utils.Constants;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.view.listener.SwipeOnScrollListener;

public class AboutActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.about_list) CardListView aboutList;
    CardArrayAdapter cardArrayAdapter;
    ArrayList<Card> cards;
    @BindView(R.id.fab) FloatingActionButton fab;
    @OnClick(R.id.fab) void onClick() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + Constants.Mail));
        startActivity(Intent.createChooser(intent , getString(R.string.choose_app)));
    }
    private int previousVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initCards();
    }

    public void initCards()
    {
        cards = new ArrayList<>();

        cards.add(new AboutCard(this , R.layout.about_card_layout_1 , 1));
        cards.add(new AboutCard(this , R.layout.about_card_layout_2 , 2));
        cards.add(new AboutCard(this , R.layout.about_card_layout_3 , 3));
        cards.add(new AboutCard(this , R.layout.about_card_layout_4 , 4));
        cards.add(new AboutCard(this , R.layout.about_card_layout_5 , 5));

        cardArrayAdapter = new CardArrayAdapter(this, cards);

        if(aboutList != null) {
            aboutList.setAdapter(cardArrayAdapter);
            aboutList.setOnScrollListener(new SwipeOnScrollListener()
            {
                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
                {
                    if (firstVisibleItem > previousVisibleItem)
                        fab.hide();
                    else if (firstVisibleItem < previousVisibleItem)
                        fab.show();

                    previousVisibleItem = firstVisibleItem;
                }
            });
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}