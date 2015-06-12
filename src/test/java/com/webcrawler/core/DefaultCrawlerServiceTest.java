package com.webcrawler.core;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class DefaultCrawlerServiceTest {


    private CrawlerServer server;


//    @Before
    public void setUp() throws Exception {
        server = new DefaultCrawlerService();
    }

//    @Test
    public void listAllLinksInTopLevelHierarchy() {

        String pageUrl = "http://localhost:63342/helloworld/com/webcrawler/core/topLevel.html";

        DefaultCrawlerService defaultCrawlerService = new DefaultCrawlerService();

        List<VisitedPage> visitedPageList = defaultCrawlerService.crawlTopLevel(pageUrl);

        assertThat(visitedPageList.size(), is(equalTo(1)));

        assertThat(visitedPageList.get(0).getUrl(), is(equalTo(pageUrl)));

    }


//    @Test
    public void crawlDomain() {

        String pageUrl = "http://localhost:63342/helloworld/com/webcrawler/core/topLevel.html";

        DefaultCrawlerService defaultCrawlerService = new DefaultCrawlerService();

        List<VisitedPage> visitedPageList = defaultCrawlerService.crawlDomain(pageUrl);

        for (VisitedPage visitedPage : visitedPageList) {
            System.out.println(visitedPage);
        }

        assertThat(visitedPageList.size(), is(equalTo(3)));


    }


}