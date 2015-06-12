package com.webcrawler.core.conditions;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public class OnlyTopPageCondition implements ShouldVisitCondition {

    private String topPageUrl;

    public OnlyTopPageCondition(String topPageUrl) {
        this.topPageUrl = topPageUrl;
    }

    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        return topPageUrl != null && topPageUrl.equals(url.getURL());
    }

    @Override
    public boolean shouldVisit(String url) {
        return topPageUrl != null && topPageUrl.equals(url);
    }
}
