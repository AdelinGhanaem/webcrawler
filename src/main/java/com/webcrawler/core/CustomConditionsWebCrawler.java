package com.webcrawler.core;

import com.webcrawler.core.conditions.ShouldVisitCondition;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public class CustomConditionsWebCrawler extends WebCrawler {


    private Object object;

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");

    private ArrayList<ShouldVisitCondition> conditions;
    private List<VisitedPage> visitedPages = new ArrayList<>();

    @Override
    public void onStart() {
        conditions = (ArrayList) myController.getCustomData();
    }

    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        boolean shouldVisit = true;

        for (ShouldVisitCondition condition : conditions) {
            shouldVisit = condition.shouldVisit(page, url);
        }
        return shouldVisit;
    }


    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (shouldBeChecked(url)) {
            if (page.getParseData() instanceof HtmlParseData) {
                HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                String text = htmlParseData.getText();
                String html = htmlParseData.getHtml();
                Set<WebURL> links = htmlParseData.getOutgoingUrls();
                Set<String> webUrls = new HashSet<>();

                for (WebURL each : links) {
                    webUrls.add(each.getURL());
                }

                Map<String, String> map = htmlParseData.getMetaTags();
                VisitedPage visitedPage = new VisitedPage(text.length(), html.length(), url, webUrls, map);
                visitedPages.add(visitedPage);
            }
        }
    }

    boolean shouldBeChecked(String url) {
        boolean shouldVisit = true;

        for (ShouldVisitCondition condition : conditions) {
            shouldVisit = condition.shouldVisit(url);
        }
        return shouldVisit;
    }


    @Override
    public Object getMyLocalData() {
        return visitedPages;
    }
}
