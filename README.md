# LearningTools
learning libraries and frameworks

List of projects:
1) CrawlerWeb: A prototype project from fetching links from within an URL.
- Currently the links are stored in memory, can be extended as a database or file system.
-  Library: Jsoup library is used for the same.
- Validation: 
  
  - already processed links are ignored
  - Hrefs which donot qualify as urls are ignored.
- References:
 - http://jsoup.org/download.
 - https://www.baeldung.com/executable-jar-with-maven
 
How to Run:
- clone project
- Mvn install
- java -jar CrawlerWeb-0.0.1-SNAPSHOT.jar https://www.baeldung.com/ <<url>>
OR

- Execute Crawler.java
- default url "https://github.com/"

