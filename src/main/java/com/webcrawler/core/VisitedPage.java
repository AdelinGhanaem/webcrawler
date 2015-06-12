package com.webcrawler.core;
import java.util.Map;
import java.util.Set;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public final class VisitedPage {


    private final int textLength;
    private final int htmlLength;
    private final String url;
    private final Set<String> links ;
    private final Map<String, String> map;

    public VisitedPage(int textLength, int htmlLength, String url, Set<String> links, Map<String, String> map) {
        this.textLength = textLength;
        this.htmlLength = htmlLength;
        this.url = url;
        this.links = links;
        this.map = map;
    }

    public int getTextLength() {
        return textLength;
    }

    public int getHtmlLength() {
        return htmlLength;
    }

    public String getUrl() {
        return url;
    }

    public Set<String> getLinks() {
        return links;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "VisitedPage{" +
                "\ntextLength=" + textLength +
                "\n, htmlLength=" + htmlLength +
                "\n, url='" + url + '\'' +
                "\n, links=" + links +
                "\n, map=" + map +
                "\n}";
    }


}
