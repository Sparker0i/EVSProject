package edu.amrita.theenvironment.blog5;

import android.content.Context;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.stream.IntStream;

import edu.amrita.theenvironment.app.App;
import edu.amrita.theenvironment.model.Model;

class Card5Maker {

    static Elements divs , imageLinks  , titleLinks;
    static ArrayList<String> links , images , titles;


    static void makeCards(Context context , Document string) {
        divs = string.getElementsByClass("card");
        imageLinks = divs.select("img");
        links = new ArrayList<>();
        images = new ArrayList<>();
        titles = new ArrayList<>();
        for (Element link : imageLinks) {
            images.add(link.absUrl("src"));
        }
        titleLinks = string.getElementsByClass("card__title-link");
        for (Element title : titleLinks) {
            links.add(title.attr("href"));
            titles.add(title.text());
        }
        System.out.println(links);
        System.out.println(images);
        System.out.println(titles);
        int n = links.size();
        for (int i = 0; i < n; i++) {
            ((App) context).cardlist.add(new Model(links.get(i) , images.get(i) , titles.get(i)));
        }
    }
}
