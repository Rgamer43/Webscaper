import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class main {

    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);

        try{
            HtmlPage page = webClient.getPage("https://rgamer43.github.io/");

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();

            System.out.println(page.asXml()); //Prints the HTML of the website
        } catch(IOException e) {

        }
    }

}
