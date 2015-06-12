package com.webcrawler.core;

import com.webcrawler.core.conditions.OnlyTopPageCondition;
import com.webcrawler.core.conditions.ShouldVisitCondition;
import com.webcrawler.core.conditions.WebsiteDomainOnly;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@Component
public class DefaultCrawlerService implements CrawlerServer {


    protected static final String CRAWL_ROOT_FOLDER = ".";

    protected static final int NUMBER_OF_THREADS = 2;

    public DefaultCrawlerService() {
    }


    @Override
    public List<VisitedPage> crawlTopLevel(final String url) {


        List<ShouldVisitCondition> shouldVisitConditions = new ArrayList<>();
        shouldVisitConditions.add(new OnlyTopPageCondition(url));

        return getVisitedPages(url, shouldVisitConditions);
    }


    @Override
    public List<VisitedPage> crawlDomain(String url) {


        List<ShouldVisitCondition> shouldVisitConditions = new ArrayList<>();
        shouldVisitConditions.add(new WebsiteDomainOnly(getDomainName(url)));

        return getVisitedPages(url, shouldVisitConditions);
    }

    public String getDomainName(String url) {

        try {
            URI uri = new URI(url);
            String domain = uri.getHost();
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        } catch (Exception e) {
            return "";
        }
    }

    private List<VisitedPage> getVisitedPages(String url, List<ShouldVisitCondition> shouldVisitConditions) {
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(CRAWL_ROOT_FOLDER);
        config.setMaxPagesToFetch(10);//TODO: needs to be configurable
        config.setPolitenessDelay(500);//TODO: needs to be configurable

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller;

        try {
            controller = new CrawlController(config, pageFetcher, robotstxtServer);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create Crawl Controller ", e);
        }

        controller.setCustomData(shouldVisitConditions); // finally a way to inject something inside crawler !!
        controller.addSeed(url);
        controller.start(CustomConditionsWebCrawler.class, NUMBER_OF_THREADS);
        List<VisitedPage> visitedPages = new ArrayList<>();
        List<Object> result = controller.getCrawlersLocalData();
        for (Object o : result) {
            if (o instanceof ArrayList) {
                visitedPages.addAll((ArrayList) o);
            }
        }
        return visitedPages;
    }


}
