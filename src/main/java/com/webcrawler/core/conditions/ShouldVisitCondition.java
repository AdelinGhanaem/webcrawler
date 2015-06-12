package com.webcrawler.core.conditions;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * An Implementations of this interface determines if a page should be visited or not !
 * Created by adelin.ghanayem@gmail.com
 */
public interface ShouldVisitCondition {
    /**
     * returns true or false depending on the condition
     * @return
     */
    boolean shouldVisit(Page page, WebURL url);

    /**
     * returns true or false depending on the condition
     * @return
     */
    boolean shouldVisit(String url);
}
