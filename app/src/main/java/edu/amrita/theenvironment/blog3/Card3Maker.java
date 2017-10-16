package edu.amrita.theenvironment.blog3;

import android.content.Context;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import edu.amrita.theenvironment.app.App;
import edu.amrita.theenvironment.model.Model;
import edu.amrita.theenvironment.utils.Constants;

class Card3Maker {

    static Elements divs , imageLinks  , titleLinks;
    static ArrayList<String> links , images , titles;

    static void makeCards(Context context , Document string) {
        divs = string.select("li");
        //System.out.println(divs);
        imageLinks = divs.select("img");
        links = new ArrayList<>();
        images = new ArrayList<>();
        titles = new ArrayList<>();
        for (Element link : imageLinks) {
            images.add(link.absUrl("src"));
        }
        titleLinks = divs.select("h3");
        for (Element title : titleLinks) {
            title.setBaseUri(Constants.blog3);
            links.add(title.select("a").attr("abs:href"));
            titles.add(title.select("a").text());
        }
        System.out.println(links);
        System.out.println(images);
        System.out.println(titles);
        int n = images.size();
        for (int i = 0; i < n; i++) {
            ((App) context.getApplicationContext()).cardlist.add(new Model(links.get(i) , images.get(i) , titles.get(i)));
        }
    }
}
