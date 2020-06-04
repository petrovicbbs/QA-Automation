package tests;

import helpers.HelloWorldHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HelloWorldTest extends BaseTest {

    @Test
    public void postiveLogInTest() throws InterruptedException{
        String mail = "bruske.ojska@yahoo.com";
        String pass = "11111111";
        int syncWait = 1200; //[ms] - Time for synchronisation ( t>=800ms )

        HelloWorldHelper.logInHelper(mail,pass,syncWait);

        Assert.assertTrue("Pozitivan Log In test case nije prošao!",isExists("xpath","/html/body/div[2]/div/div[2]/div/div/div/div[1]/div[1]"));
        //Assert.assertTrue("Pozitivan Log In test case nije prošao!",SWS("xpath","/html/body/div[2]/div/div[2]/div/div/div/div[1]/div[1]/strong").getText().contains("Moj nalog"));
    }

    @Test
    public void negativeLogInTest() throws InterruptedException{
        String mail = "bruske.ojska@yahoo.com";
        String pass = "11111112";
        int syncWait = 1200; //[ms] - Time for synchronisation ( t>=800ms )

        HelloWorldHelper.logInHelper(mail,pass,syncWait);

        Assert.assertTrue("Negativan Log In test case je prošao!",!isExists("xpath","/html/body/div[2]/nav/div/div[1]/div/span"));
        //Assert.assertTrue("Negativan Log In test case je prošao!",SWS("xpath","/html/body/div[2]/div[1]/div/div[2]/div/div/div/div/ul/li/ul/li/span").getText().contains("Email adresa ili lozinka nisu validni."));
    }

//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

    @Test
    public void searchingForJobAdsTest() throws InterruptedException {
//▓ Searching for technologies
        // Seniority - {0} for Junior, {1} for Intermediate, {2} for Senior
        int seniorityLvl = 0;
        String[] technologies = {"QA"}; //"C#" "SQL" "QA"
        String[] cities = {"Beograd"}; //"Novi Sad"

        int syncWait = 1200; //[ms] - Time for synchronisation ( t>=800ms )
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//  ▓ Quick check ▓
// ===========================================================================
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓Bookmarks▓[Ctrl+<R>]▓▓▓||▓▓▓[Shift+F11]▓▓▓▓▓  GoTo [Ctrl+Shift+A] ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //R.▓=======================================================================
        //1.▓ "Senioritet" xpath CHECK ▓▓▓▓▓▓▓  HelloWorldHelper:160  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  /html/body/div[1]/form/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/a/span[1]
        //2.▓ "Prikazi jos" btn CHECK ▓▓▓▓▓▓▓▓  HelloWorldHelper:193  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  driver.findElement(By.tagName("center"))
        //3.▓ "Grad" txt xpath CHECK ▓▓▓▓▓▓▓▓▓  HelloWorldHelper:128  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  /html/body/div[1]/form/div[1]/div/div[1]/div[4]/div/div[2]/ul/li["+(i+1)+"]/input
        //4.▓ 1st Tech xpath CHECK ▓▓▓▓▓▓▓▓▓▓▓  HelloWorldHelper:56   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  /html/body/div[2]/form/div[2]/div/div/div/div/div/div[2]/div/center/div/div[1]/div/ul/li/input
        //5.▓ 2nd Tech xpath CHECK ▓▓▓▓▓▓▓▓▓▓▓  HelloWorldHelper:94   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  /html/body/div[1]/form/div[1]/div/div[1]/div[3]/div/div/ul/li["+(i+1)+"]/input
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//========================================================================================================================================================
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        boolean isAllEmpty = technologies.length == 0 && cities.length == 0 ? true : false;
        if (isAllEmpty) {
            System.out.println("Molim Vas unestite neki parametar pretrage!");
        }
        else {
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            try {
                HelloWorldHelper.searchingForJobAdsHW(technologies, cities, seniorityLvl, syncWait);
            } catch (Exception ex) {
                System.out.println("▓ Došlo je do greške! Proverite parametre pretrage): " + ex.getMessage());
            }
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

            String senioritet = "";
            switch (seniorityLvl) {
                case 0:
                    senioritet = "junior";
                    break;
                case 1:
                    senioritet = "Intermediate";
                    break;
                case 2:
                    senioritet = "Senior";
                    break;
            }
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            //WebElement results = SWS("xpath", "/html/body/div[1]/form/div[2]/div/div/div[2]/div[2]/div[1]");
            WebElement results = SWS("className", "search-results");
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

            List<WebElement> jobItems = results.findElements(By.className("job-item"));

            SoftAssert soft = new SoftAssert();

//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓ Checking tags for technologies and seniority, and ads for cities▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            //▓ Checking tags of ads results for technologies ▓
            for (WebElement jobItem : jobItems) {

                scrollToElement(jobItem);

                WebElement tags = jobItem.findElement(By.className("jobtags"));

                //▓ Checking technologies of ads results ▓
                int i = 0;
                for (String tech : technologies) {
                    if (tags.getText().contains(tech.toLowerCase())) {
                        i++;
                    }
                }
                //▓ Checking technologies of ads results ▓
                soft.assertTrue(i >= 1, "Oglas: " + jobItem.findElement(By.tagName("h3")).getText() + " ne sadrži tražene tehnologije");

                //▓ Checking seniority of ads results ▓
                soft.assertTrue(tags.getText().contains(senioritet.toLowerCase()), "Oglas: " + jobItem.findElement(By.tagName("h3")).getText() + " ne sadrži potrebni senioritet");

                //▓ Checking city of ads results ▓
                if (cities.length > 0) {

                    WebElement location = jobItem.findElement(By.xpath(".//div[2]/div[1]/p[1]"));

                    int j = 0;

                    for (String city : cities) {
                        boolean isBelgrade = city == "Beograd" && location.getText().contains("Belgrade") ? true : false;
                        boolean isRemote = location.getText().contains("Remote") || location.getText().contains("remote") ? true : false;

                        if (location.getText().contains(city) || isRemote) {
                            if (isRemote) {
                                System.out.println("▓ Napomena: Oglas \"" + jobItem.findElement(By.tagName("h3")).getText() + " je Remote!");
                            }
                            j++;
                        } else if (isBelgrade) {
                            j++;
                        }
                    }
                    //▓ Checking cities of ads results ▓
                    soft.assertTrue(j >= 1, "Oglas: " + jobItem.findElement(By.tagName("h3")).getText() + " ne sadrži tražene gradove");
                }
            }

            //▓ Checking all asserts ▓
            soft.assertAll();
        }
    }

    @Test
    public void searchingForCompany() throws InterruptedException {
        String company = "InterVenture"; // Asseco Infostud InterVenture
        String city = ""; //Beograd

        int syncWait = 1200; //[ms] - Time for synchronisation ( t>=800ms )
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        boolean isBothEmpty = company == "" && city == ""?true:false;
        boolean isBothFilled = company != "" && city != ""?true:false;

        if (isBothEmpty||isBothFilled) {
            System.out.println("▓ Molim Vas unesite ispravne parametre pretrage pa pokušajte ponovo ▓");
            if(isBothFilled)
            {
                System.out.println("▓ Napomen: Ne možete pretraživati sa oba parametra");
            }
        }
        else {
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            try {
                HelloWorldHelper.searchingForCompany(company, city, syncWait);
            }
            catch (Exception ex) {
                System.out.println("▓ Došlo je do greške! Proverite parametre pretrage): "+ex.getMessage());
            }
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

            waitForIt(syncWait);

            //▓ Assert for company name ▓
            if (company != "") {
                WebElement companyName;

                // Company name on regular profile
                if (isExists("xpath", "/html/body/div[1]/div[4]/div/div/div/div/div/div/h1")) {
                    companyName = SWS("xpath", "/html/body/div[1]/div[4]/div/div/div/div/div/div/h1");
                } else {
                    // Company name on advanced profile
                    WebElement companyPage = SWS("id", "ap-video-basic-info");
                    companyName = SWS("xpath", "//div/div[1]/span[2]/h2", companyPage);
                }
                //▓ Assert for company name ▓
                Assert.assertTrue("Test je pao jer nismo u traženoj kompaniji!", companyName.getText().contains(company));
            }

            //▓ Assert for company location ▓
            if (company == "" && city != "") {
                // Company results
                WebElement companyResults = SWS("xpath", "/html/body/div[1]/div[5]/div/div/div/div[2]/div/div[2]");
                // If there is non company in selected city
                if (companyResults.getText().contains("Nema rezultata za zadate kriterijume")) {
                    System.out.println("Izabrani grad nema oglašavane kompanije na ovom sajtu!");
                    Assert.assertTrue("Test je pao - Nešto se zamrsilo!", companyResults.getText().contains("Nema rezultata za zadate kriterijume"));
                }
                else {
                    // If there is at least one company in selected city
                    List<WebElement> companies = ToListOfWEBy("className", "review-holder", companyResults);

                    //WebElement rndCompany;
                    WebElement companyName;

                    // Setting random company from the results
                    WebElement rndCompany = companies.get((int) (Math.random() * (companies.size())));

                    companyName = rndCompany.findElement(By.tagName("a"));

                    scrollToElement(rndCompany.findElement(By.xpath("//div")));

                    waitForIt(syncWait);

                    //▓ Clicking on company name
                    companyName.click();

                    waitForIt(syncWait);

                    WebElement companyInfo = null;
                    WebElement companyAdress = null;

                    // Company adress(city) on advanced profile page
                    if (isExists("xpath", "/html/body/div[1]/div[9]/div/div/div[1]/span[1]/p")) {
                        companyAdress = SWS("xpath", "/html/body/div[1]/div[9]/div/div/div[2]/div[4]");
                        companyInfo = SWS("xpath", "/html/body/div[1]/div[9]/div/div/div[2]/div[3]/p");
                    }
                    // Company adress(city) on regular profile
                    else {
                        waitForIt(syncWait);

                        // Checking adress <div>
                        WebElement aboutCompany = SWS("xpath", "/html/body/div[1]/div[5]/div/div/div/div/div[1]/div/div/a[1]");
                        aboutCompany.click();

                        waitForIt(syncWait);

                        // Checking info
                        companyInfo = SWS("xpath", "/html/body/div[1]/div[5]/div/div/div/div/div[3]/div/div[2]/div/div");
                        companyAdress = null;

                        //Checking on adress <div>
                        if (isExists("xpath", "/html/body/div[1]/div[5]/div/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/div[1]")) {
                            companyAdress = SWS("xpath", "/html/body/div[1]/div[5]/div/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/div[1]");
                        }
                        else {
                            //Checking on short APR data <div>
                            companyAdress = SWS("xpath", "/html/body/div[1]/div[5]/div/div/div/div/div[3]/div/div[1]/div/div[2]/div[1]/div[7]");
                        }
                    }

                    // Assert for city of random city
                    if (companyAdress.getText().contains(city)) {
                        Assert.assertTrue("Test je pao jer nismo na profilu tražene kompanije", companyAdress.getText().contains(city));
                    }
                    else if (companyInfo.getText().contains(city)) {
                        Assert.assertTrue("Test je pao jer nismo na profilu tražene kompanije", companyInfo.getText().contains(city));
                    }
                    else {
                        Assert.assertTrue("Test je pao jer nismo na profilu tražene kompanije", HelloWorldHelper.checkAPR(city, syncWait));
                    }
                }
            }
        }
    }

    @Test
    public void searchingForArticleInITColumn() throws InterruptedException {
        String text = "InterVenture"; // Infostud InterVenture

        int syncWait = 1200; //[ms] - Time for synchronisation ( t>=800ms )
// ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
// ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        if (text == "") {
            System.out.println("Molim Vas unestite parametar pretrage!");
        }
        else {
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            try {
                HelloWorldHelper.searchingForArticle(text, syncWait);
            }
            catch (Exception ex){
                System.out.println("▓ Došlo je do greške! Proverite parametre pretrage): "+ex.getMessage());
            }
            // ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

            waitForIt(syncWait);

            if (isExists("id", "post_container")) {
                WebElement results = SWS("id", "post_container");
                System.out.println("Izgleda da nema članaka za traženi pojam!");
                Assert.assertTrue("Test je pao!", results.getText().contains("Nema rezultata pretrage"));
            } else {
                WebElement articleTitle = SWS("id", "page-title");
                WebElement articleText = SWS("className", "entry_content");

                // Assert for article title and content
                Assert.assertTrue("Test je pao jer na stranici nema traženog pojma", HelloWorldHelper.checkingTextOnArticle(text, articleTitle) || HelloWorldHelper.checkingTextOnArticle(text, articleText));
            }
        }
    }
}