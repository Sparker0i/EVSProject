package edu.amrita.theenvironment.blog1;

import android.content.Context;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import edu.amrita.theenvironment.app.App;
import edu.amrita.theenvironment.model.Model;

class Card1Maker {

    static Elements divs , titleLinks;
    static ArrayList<String> links , images , titles;


    static void makeCards(Context context , Document string) {
        divs = string.select("article");
        for (int i = 5; i < divs.size(); ++i) {
            divs.remove(i);
        }
        links = new ArrayList<>();
        images = new ArrayList<>();
        titles = new ArrayList<>();
        for (Element div : divs) {
            images.add(div.select("img").first().absUrl("data-orig-file"));
        }
        titleLinks = string.getElementsByClass("entry-title");
        for (Element title : titleLinks) {
            links.add(title.select("a").attr("href"));
            titles.add(title.select("a").text());
        }
        System.out.println(links);
        System.out.println(images);
        System.out.println(titles);
        int n = images.size();
        for (int i = 0; i < n; i++) {
            ((App) context).cardlist.add(new Model(links.get(i) , images.get(i) , titles.get(i)));
        }
    }
}
