package htmlgen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakeHTMLTest {
    private PageData pageData;
    private WikiPage wikiPage;

    @BeforeEach
    public void setup() {
        pageData = new PageData(
                "TestPage",
                "/path/to/test/page",
                "<TestPageContent></TestPageContent>"
        );
        wikiPage = pageData.getWikiPage();
    }

    @Test
    public void testWithoutTestAttribute() throws Exception {
        String html = MakeHTML.testableHtml(pageData, true);
        assertEquals("<TestPageContent></TestPageContent>", html);
    }

    @Test
    public void testWithTestAttributeAndSuiteSetup() throws Exception {
        pageData.addAttribute("Test");

        String html = MakeHTML.testableHtml(pageData, true);
        String expectedHTML = "!include -setup . <Rendered><FullPath>/path/to/test/page/Suite Steup Name</FullPath></Rendered>\n"
                            + "!include -setup . <Rendered><FullPath>/path/to/test/page/SetUp</FullPath></Rendered>\n"
                            + "<TestPageContent></TestPageContent>!include -teardown . <Rendered><FullPath>/path/to/test/page/TearDown</FullPath></Rendered>\n"
                            + "!include -teardown . <Rendered><FullPath>/path/to/test/page/Suite Teardown Name</FullPath></Rendered>\n";
        assertEquals(expectedHTML, html);
    }

    @Test
    public void testWithTestAttributeWithoutSuiteSetup() throws Exception {
        pageData.addAttribute("Test");
        String html = MakeHTML.testableHtml(pageData, false);
        String expectedHTML = "!include -setup . <Rendered><FullPath>/path/to/test/page/SetUp</FullPath></Rendered>\n"
        					+ "<TestPageContent></TestPageContent>!include -teardown . <Rendered><FullPath>/path/to/test/page/TearDown</FullPath></Rendered>\n";
        assertEquals(expectedHTML, html);
    }
}
