package com.webcrawler.core.conditions;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public class WebsiteDomainOnly implements ShouldVisitCondition {


    private String domain;


    public WebsiteDomainOnly(String domain) {
        this.domain = domain;
    }


    @Override
    public boolean shouldVisit(Page page, WebURL url) {
        String stringUrl = url.getURL();
        return !"".equals(domain) && stringUrl.contains(domain);
    }


    @Override
    public boolean shouldVisit(String url) {
        return !"".equals(domain) && url.contains(domain);
    }
}
