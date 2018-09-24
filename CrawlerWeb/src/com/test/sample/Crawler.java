package com.test.sample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private List<String> links = new ArrayList<>();

	public static void main(String[] args) {
		String url = "https://www.citiustech.com/";
	
		Crawler crawler = new Crawler();
		try {
			URL urlObj = new URL(url);
			crawler.processLink(url, urlObj.getHost());
			System.out.println(crawler.links);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processLink(String url, String host) throws IOException {
		
		if (!links.contains(url)) {
			links.add(url);
			System.out.println(url);
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();
			Elements questions = doc.select("a[href]");
			for (Element link : questions) {
				try{
				URL urlObj = new URL(link.attr("href"));
				if (urlObj.getHost().contains(host)) {

					processLink(link.attr("abs:href"), host);
				}
				}
				catch(MalformedURLException ex){
					//log skipped urls
				}
			}
		}
	}
}
