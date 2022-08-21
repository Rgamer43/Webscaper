import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.Scanner;

public class main {

    //Made by Rgamer43, using HTMLUnit

    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setPrintContentOnFailingStatusCode(false);

        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Where would you like to scrape?");
            HtmlPage page;
            String target = input.nextLine();

            if(target.startsWith("https://"))
                page = webClient.getPage(target);
            else page = webClient.getPage("https://" + target);

            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();

            System.out.println(page.asXml()); //Prints the HTML of the website
        } catch(IOException e) {
            System.out.println("ERROR!");
        }
    }

}
