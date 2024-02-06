package htmlgen;

public class MakeHTML {

	
    public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception
    {
       return new SetupTearDownSurrounder(pageData, includeSuiteSetup).surround();
    }
    

    private static class SetupTearDownSurrounder{

        private WikiPage wikiPage;
        private String content;
        private PageData pageData;
        private boolean includeSuiteSetup;
        private PageCrawlerImpl crawler;

        public SetupTearDownSurrounder(PageData pageData, boolean includeSuiteSetup){
            this.wikiPage = pageData.getWikiPage();
            this.content = "";
            this.pageData = pageData;
            this.includeSuiteSetup = includeSuiteSetup;
            this.crawler = wikiPage.getPageCrawler();
        }

        public String surround() {
            if(isTestPage())
                surroundPageWithSetupsAndTeardowns();
            return pageData.getHtml();
        }

        private void surroundPageWithSetupsAndTeardowns() {
            content += includeSetups();
            content += pageData.getContent();
            content += includeTeardowns();
            pageData.setContent(content.toString());
        }

        private boolean isTestPage() {
            return pageData.hasAttribute("Test");
        }

        private String includeTeardowns() {
            WikiPage teardown = PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
            String teardowns = "";
            teardowns += includePage("teardown", teardown);
            if(includeSuiteSetup)
                teardowns += includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
            return teardowns;
        }

        private String includeSetups() {
            String setups = "";
            if(includeSuiteSetup)
                setups += includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
            setups += includeIfInherited("setup", "SetUp");
            return setups;
        }

        private String includeIfInherited(String mode, String pageName) {
            WikiPage page = PageCrawlerImpl.getInheritedPage(pageName, wikiPage);
            return includePage(mode, page);
        }

        private String includePage(String mode, WikiPage suiteSetup) {
            WikiPagePath pagePath = crawler.getFullPath(suiteSetup);
            String pagePathName = PathParser.render(pagePath);
            return String.format("!include -%s . %s\n", mode, pagePathName);
        }

    }

}










