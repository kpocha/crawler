package com.crawler.megatone;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Danilo Pérez Ortega
 * Date: 27/01/17
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public class HTMLParser {
    public static void main(String[] args) {
        Crawler c = new Crawler();

        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("https://megatone.net").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            c.getCategory(doc);
            c.getSubCategory(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
    class Crawler{
        public void getSubCategory(Document doc){
            Elements subcategoria = doc.select("div .bgcSubCategoria > div .divSubCategoria");
            Elements links = subcategoria.select("a");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
            }
        }
        public void getCategory(Document doc){
            Elements categoria = doc.select("div .bgcCategoria");
            //Elements links = categoria.select("a");
            for (Element link : categoria) {

                // get the value from href attribute
                //System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
            }
        }
    }
