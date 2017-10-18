package edu.amrita.theenvironment.cards;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;


import edu.amrita.theenvironment.R;
import edu.amrita.theenvironment.activity.LicenseActivity;
import it.gmariotti.cardslib.library.internal.Card;

public class AboutCard extends Card {
    private int type;
    private Context context;

    public AboutCard(Context context, int innerLayout, int type) {
        super(context, innerLayout);
        this.type = type;
        this.context = context;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        super.setupInnerViewElements(parent, view);

        switch (type) {
            case 1:
            {
                (parent.findViewById(R.id.more_apps)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.other_apps_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.aaditya)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.github_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.aswin)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.aswin_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.aswin_link)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.aswin_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.amretanand)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.amretanand_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.amretanand_link)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.amretanand_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.rahul)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.rahul_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.rahul_link)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.rahul_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.sachin)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.amretanand_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.sachin_link)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.sachin_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                break;
            }

            case 2:
            {
                (parent.findViewById(R.id.blog_1)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.blog_1_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.blog_2)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.blog_2_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                (parent.findViewById(R.id.blog_3)).setOnClickListener(
                        new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(context.getString(R.string.blog_3_link)));
                                context.startActivity(intent);
                            }
                        }
                );
                break;
            }

            case 3:
            {
                parent.findViewById(R.id.lib_2).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showLicense(2);
                    }
                });

                parent.findViewById(R.id.lib_3).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showLicense(3);
                    }
                });

                parent.findViewById(R.id.lib_4).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showLicense(4);
                    }
                });

                parent.findViewById(R.id.lib_6).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showLicense(6);
                    }
                });

                parent.findViewById(R.id.lib_9).setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        showLicense(9);
                    }
                });
                parent.findViewById(R.id.lib_10).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showLicense(10);
                    }
                });
                parent.findViewById(R.id.lib_11).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showLicense(11);
                    }
                });
                break;
            }

            case 4:
            {
                parent.findViewById(R.id.license_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(context.getString(R.string.license_link)));
                        context.startActivity(intent);
                    }
                });
                break;
            }
        }
    }

    private void showLicense(int libId) {
        Intent intent = new Intent(context, LicenseActivity.class);
        intent.putExtra("libId", libId);
        context.startActivity(intent);
    }
}