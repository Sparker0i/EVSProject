package edu.amrita.theenvironment.activity;

import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.app.App;
import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.IconSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class MainActivity extends AppCompatActivity {

    MaterialDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title(getString(R.string.please_wait))
                .content(getString(R.string.loading))
                .progress(true , 0);
        pd = builder.build();
        pd.show();
        createCard();
    }

    private void createCard() {
        final Context context = this;
        final ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < App.cardlist.size(); ++i) {
            ArrayList<BaseSupplementalAction> actions = new ArrayList<>();
            final int j = i;
            IconSupplementalAction t1 = new IconSupplementalAction(context, R.id.text1);
            t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    String url = App.cardlist.get(j).link;
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, Uri.parse(url));
                }
            });
            actions.add(t1);

            MaterialLargeImageCard card =
                    MaterialLargeImageCard.with(this)
                            .setTextOverImage(App.cardlist.get(j).title)
                            .useDrawableExternal(new MaterialLargeImageCard.DrawableExternal() {
                                @Override
                                public void setupInnerViewElements(ViewGroup parent, View viewImage) {

                                    Picasso.with(context).setIndicatorsEnabled(true);  //only for debug tests
                                    Picasso.with(context)
                                            .load(App.cardlist.get(j).imageLink)
                                            .error(R.drawable.ic_launcher)
                                            .into((ImageView) viewImage);
                                }
                            })
                            .setupSupplementalActions(R.layout.carddemo_native_material_supplemental_actions_large_icon, actions)
                            .build();

            CardHeader header = new CardHeader(this);
            card.addCardHeader(header);

            cards.add(card);
        }

        CardArrayRecyclerViewAdapter mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, cards);

        //Staggered grid view
        CardRecyclerView mRecyclerView = findViewById(R.id.recylerview);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCardArrayAdapter);
        pd.hide();
    }
}
