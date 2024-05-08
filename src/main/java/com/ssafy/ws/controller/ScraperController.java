package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.ws.WebScraper;

@Controller
public class ScraperController {

    @GetMapping("/")
    public String home(Model model) {
        return "index.html";
    }

    @GetMapping("/scraped-data")
    public String scrapedData(Model model) {
        WebScraper scraper = new WebScraper();
        String data = scraper.scrape();
        model.addAttribute("scrapedData", data);
        return "scrapedData";  // 새로운 HTML 페이지 이름
    }
    
    @GetMapping("/scraped-data-api")
    @ResponseBody
    public String getScrapedData() {
        WebScraper scraper = new WebScraper();
        String data = scraper.scrape();
        // 데이터를 HTML 테이블로 포맷팅
        return formatDataAsHtmlTable(data);
    }

    private String formatDataAsHtmlTable(String data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border='1'>");
        sb.append("<tr><th>Data</th></tr>");
        sb.append("<tr><td>").append(data).append("</td></tr>");
        sb.append("</table>");
        return sb.toString();
    }
}