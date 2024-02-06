package htmlgen;

public class WikiPage {

    String name = "";
    String path = "";

    WikiPage(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public PageCrawlerImpl getPageCrawler() {
        return new PageCrawlerImpl("<Crawler>" + path + "</Crawler>");
    }

    public String getPath() {
        return "<PageCrawlerImpl>" + path + "</PageCrawlerImpl>";
    }
}
