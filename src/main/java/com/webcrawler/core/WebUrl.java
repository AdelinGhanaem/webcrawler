package com.webcrawler.core;

import edu.uci.ics.crawler4j.url.WebURL;

/**
 * Created by adelin.ghanayem@cayetanogaming.com on 6/12/15.
 */
public class WebUrl extends WebURL {

    private String url;

    public void setUrl(String url) {
        this.url = super.getURL();
    }
}
