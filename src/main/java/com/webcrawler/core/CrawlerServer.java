package com.webcrawler.core;

import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
public interface CrawlerServer {


    /**
     * @param url
     * @return
     */
    public List<VisitedPage> crawlTopLevel(String url);

    /**
     *
     * @param url
     * @return
     */
    public List<VisitedPage> crawlDomain(final String url);

}