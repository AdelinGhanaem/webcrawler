package com.webcrawler.web;

import com.webcrawler.core.CrawlerServer;
import com.webcrawler.core.VisitedPage;
import edu.uci.ics.crawler4j.url.WebURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by adelin.ghanayem@gmail.com
 */
@RestController
@RequestMapping(value = "/")
public class MainController {


    private CrawlerServer server;

    @Autowired
    public MainController(CrawlerServer server) {
        this.server = server;
    }

    @RequestMapping(value = "/crawl", method = RequestMethod.GET)
    public ModelAndView modelAndView(@RequestParam String url) {

        List<VisitedPage> visitedPageList = server.crawlTopLevel(url);
        List<VisitedPage> entireDomain = server.crawlDomain(url);

        Map<String, Object> map = new HashMap<>();
        map.put("topLevel",visitedPageList);
        map.put("allDomain",entireDomain);

        ModelAndView mav = new ModelAndView("index.jsp");
        mav.addAllObjects(map);
        return mav;
    }

}
