package utils;

import entity.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Link> parse(String url) throws IOException {

        List<Link> links = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("a");

        for (Element e : elements) {
            if (!e.absUrl("href").equals("")){

                if(!e.ownText().equals("")){
                    links.add(new Link(e.absUrl("href"),e.ownText()));
                }
                else if (!e.child(0).ownText().equals("")){
                    links.add(new Link(e.absUrl("href"),e.child(0).ownText()));
                }
                else  links.add(new Link(e.absUrl("href"),e.absUrl("href")));
            }

        }

        return links;
    }


}
