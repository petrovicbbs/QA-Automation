package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

import java.util.List;
import java.util.regex.Pattern;

public class HelloWorldHelper extends BaseHelper{

    public static void logInHelper(String mail, String pass,int syncWait) throws InterruptedException {
        String url = "https://www.winwin.rs/";
        driver.get(url);

        waitForIt(syncWait);

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div[2]/div[2]/ul/li[1]"));
        action.moveToElement(we).moveToElement(we.findElement(By.xpath(".//ul/li/ul/li[1]/a"))).click().build().perform();

        waitForIt(syncWait);

        WebElement txtMail = SWS("id","email");
        txtMail.click();
        txtMail.sendKeys(mail);

        WebElement txtPass = SWS("id","pass");
        txtPass.click();
        txtPass.sendKeys(pass);

        WebElement btnLog = SWS("id","send2");
        btnLog.click();
    }

//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

    public static void searchingForJobAdsHW(String[] technologies,String[] cities, int seniorityLvl, int syncWait) throws InterruptedException {
//▓ Navigate to "https://www.helloworld.rs/" ▓
        String url = "https://www.helloworld.rs/";
        driver.get(url);

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Covid and Cookie modal ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓ Closing modals for best user experience ▓
        closeModals();

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Entering 1st technology from array ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        WebElement wideSearchBox = SWS("xpath", "/html/body/div[2]/form/div[2]/div/div/div/div/div/div[2]/div/center/div/div[1]/div/ul/li/input");
        scrollToElement(wideSearchBox);

//▓ Clicking on search box ▓
        wideSearchBox.click();

//▓ Insertng first technology ▓
        wideSearchBox.sendKeys(technologies[0]);

        // Waiting to refresh results
        waitForIt(syncWait);

//▓ Clicking on wanted tech ▓ - ▓ 1st tech ▓ (first technology which leads to redirection) ▓
        try {
            WebElement div = SWS("xpath", "/html/body/div[15]");
            WebElement ul = SWS("tagName", "ul", div);

            // Choosing 1st tech
            List<WebElement> options = ToListOfWEBy("tagName","li",ul);
            for (WebElement option : options) {
                if (option.getText().equals(technologies[0])) {
                    option.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("▓ Greška ▓: " + e.getMessage());
        }

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Entering 2nd(and on) technology(ies) from array ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓ If there's more then one tech ▓
        if (technologies.length > 1) {
            //▓ Adding the rest of technologies from List
            for (int i = 1; i < technologies.length; i++) {
                waitForIt(syncWait);
//▓ Clicking on technology search box ▓
                WebElement technologySearchBox = SWS("xpath", "/html/body/div[1]/form/div[1]/div/div[1]/div[3]/div/div/ul/li["+(i+1)+"]/input");
                technologySearchBox.click();

//▓ Inserting 2nd(and so on) technology(ies) ▓
                technologySearchBox.sendKeys(technologies[i]);

                // Waiting to refresh results
                waitForIt(syncWait);

                // <div>
                WebElement div = SWS("id", "select2-drop");
                // <div>/<ul>
                WebElement ul = SWS("tagName", "ul", div);

//▓ Clicking on wanted tech ▓
                List<WebElement> options = ToListOfWEBy("tagName", "li", ul);
                for (WebElement option : options) {
                    if (option.getText().equals(technologies[i])) {
                        option.click();
                        break;
                    }
                }
            }
            waitForIt(syncWait);
        }

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Entering "Grad" ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓ Adding city(ies) to field ▓
        for (int i = 0; i < cities.length; i++) {
            waitForIt(syncWait);

//▓ Clicking on City text box ▓
            WebElement citySearchBox = SWS("xpath", "/html/body/div[1]/form/div[1]/div/div[1]/div[4]/div/div[2]/ul/li["+(i+1)+"]/input");
            citySearchBox.click();

//▓ Adding next city to field ▓
            citySearchBox.sendKeys(cities[i]);

            waitForIt(syncWait);

//▓ Clicking on wanted option ▓
            WebElement div = SWS("id", "select2-drop");
            WebElement ul = SWS("className","select2-results",div);

            waitForIt(syncWait);

            List<WebElement> cityies = ToListOfWEBy("tagName", "li", ul);
            for (WebElement city : cityies) {
                if (city.getText().equals(cities[i])) {
                    city.click();
                    break;
                }
            }
            waitForIt(syncWait);
        }

        // Waiting to refresh results
        waitForIt(syncWait);

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Entering "Senioritet" ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓ Click to open drop down for selecting "Senioritet" ▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓seniorityDropDown▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        WebElement seniorityDropDown = SWS("xpath", "/html/body/div[1]/form/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/a/span[1]");
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

        seniorityDropDown.click();

        // Waiting to refresh results
        waitForIt(syncWait);

//▓ Selecting "Senioritet" ▓
        WebElement div = SWS("id", "select2-drop");
        WebElement ul = SWS("tagName", "ul", div);

        List<WebElement> seniorityDropDownResults = ToListOfWEBy("tagName", "li", ul);

        int i = 0;
        for (WebElement item : seniorityDropDownResults) {
            if (i == seniorityLvl) {
                item.click();
                break;
            }
            i++;
        }

        // Waiting to refresh results
        waitForIt(syncWait);

        // Finale results
        if (driver.findElements(By.tagName("center")).size() != 0) {

            // Scroll to button to show more results
            //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓showMore▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
            scrollToElement(driver.findElement(By.tagName("center")));

            WebElement showMore = SWS("tagName", "a", driver.findElement(By.tagName("center")));
            //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

//▓ Click on "Pokaži još"
            showMore.click();

            // Waiting to refresh results
            waitForIt(syncWait);
        }
    }

    static public void closeModals() {

        // If covid modal is displayed, close it
        if(isExists("id","covid19-modal")&&driver.findElement(By.id("covid19-modal")).isDisplayed()) {
                // Covid modal - Button "Zatvori" on covid modal
                SWS("className","close").click();
                System.out.println("▓ Sajt je podigao modal Covid19 koji smo zatvorili. ▓");
            }
        else {
        System.out.println("▓ Sajt nije podigao modal Covid19 ▓");
    }

        // If cookies modal is displayed, close it
        if(isExists("className","cookie-btn-wrapper")&&driver.findElement(By.className("cookie-btn-wrapper")).isDisplayed()) {
            // Clicking on "U redu" to close <div>
            SWS("className","cookie-link").click();
            System.out.println("▓ Sajt je podigao obaveštenje za kolačiće koje smo zatvorili ▓");
        }
        else {
            System.out.println("▓ Sajt nije podigao obaveštenje za kolačiće ▓");
        }

// Staro
/*
        try {
            if (driver.findElement(By.id("covid19-modal")).isDisplayed()) {
                // Covid modal - Button "Zatvori" on covid modal
                SWS("className","close").click();
                System.out.println("▓ Sajt je podigao modal Covid19 koji smo zatvorili. ▓");
            }
        } catch (Exception e) {
            System.out.println("▓ Sajt nije podigao modal Covid19 ▓ - " + e.getMessage());
        }

        // Closing cookies notification
        try {
            if (driver.findElement(By.className("cookie-btn-wrapper")).isDisplayed()) {
                // Clicking on "U redu" to close <div>
                SWS("className","cookie-link").click();
                System.out.println("▓ Sajt je podigao obaveštenje za kolačiće koje smo zatvorili ▓");
            }
        } catch (Exception e) {
            System.out.println("▓ Sajt nije podigao obaveštenje za kolačiće ▓ -" + e.getMessage().toString());
        }
*/
    }

    public static void searchingForCompany(String company, String city, int syncWait) throws InterruptedException {
//▓ Navigate to "https://www.helloworld.rs/" ▓
        String url = "https://www.helloworld.rs/";
        driver.get(url);

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Covid and Cookie modal ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓ Closing modals for best user interface ▓
        closeModals();

//▓ Clicking on button "IT Insajder"
        WebElement itInsiderBtn = SWS("xpath", "/html/body/div[2]/div[3]/div/div[3]/ul/li[4]/a/div");
        scrollToElement(itInsiderBtn);
        itInsiderBtn.click();

        waitForIt(syncWait);

        if(company!="") {
//▓ Clicking on text box for company
            WebElement companySearchBox = SWS("xpath", "/html/body/div[1]/div[4]/div/div/div/div/div/div[5]/div/div/form/div/div[1]/div/a");
            companySearchBox.click();

            waitForIt(syncWait);

//▓ Entering company name
            // Finding dynamic text box
            WebElement dynCompanyTxt = SWS("xpath", "/html/body/div[15]/div/input");
            dynCompanyTxt.sendKeys(company);


            waitForIt(syncWait);

            // Results - <ul>
            WebElement companyResults = SWS("xpath", "/html/body/div[15]/ul");
            try {
                // Making list of company results
                List<WebElement> companies = ToListOfWEBy("tagName", "li", companyResults);
                for (WebElement comp : companies) {
                    if (comp.getText().contains(company)) {
                        comp.click();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("▓ Greška ▓: " + e.getMessage());
            }
        }

        if(company=="" && city!="") {
            //▓ Clicking on text box for company
            WebElement citySearchBox = SWS("id","s2id_location");
            citySearchBox.click();

            waitForIt(syncWait);

            WebElement dynCityTxt = SWS("xpath","/html/body/div[15]/div/input");
            dynCityTxt.sendKeys(city);

            waitForIt(syncWait);

            // Results - <ul>
            WebElement cityResults = SWS("xpath","/html/body/div[15]/ul");
            try {
                // Making list of city results
                List<WebElement> citiesResults = ToListOfWEBy("tagName","li",cityResults);
                for (WebElement cityItem : citiesResults) {
                    if (cityItem.getText().equals(city)) {
                        cityItem.click();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("▓ Greška ▓: " + e.getMessage());
            }
        }
        waitForIt(syncWait);
    }

    public static boolean checkAPR(String city, int syncWait) throws InterruptedException {

        boolean result=false;

        WebElement apr = SWS("xpath","/html/body/div[1]/div[5]/div/div/div/div/div[1]/div/div/a[3]");
        apr.click();

        waitForIt(syncWait);

        WebElement infoBox = SWS("xpath","/html/body/div[1]/div[5]/div/div/div/div/div[5]/div");
        result=infoBox.getText().contains(city)?true:infoBox.getText().contains(city.toUpperCase())?true:infoBox.getText().contains(city.toLowerCase())?true:false;

        return result;
    }

    public static void searchingForArticle(String text, int syncWait) throws InterruptedException {
//▓ Navigate to "https://www.helloworld.rs/" ▓
        String url = "https://www.helloworld.rs/";
        driver.get(url);

        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        //▓▓▓ Covid and Cookie modal ▓▓▓
        //▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
//▓ Closing modals for best user interface ▓
        closeModals();

//▓ Clicking on button "IT Kolumna"
        scrollToElement(driver.findElement(By.id("main-menu")));
        WebElement itKolumnaBtn = SWS("xpath", "/html/body/div[1]/div[3]/div/div[3]/ul/li[5]/a");

        itKolumnaBtn.click();

        waitForIt(syncWait);

        WebElement searchForm = SWS("xpath", "/html/body/div[1]/div[4]/div/div/div/div/div/div/div/div/div/form/div/div");
        WebElement searchBox = SWS("tagName","input",searchForm);
        WebElement searchBoxBtn = SWS("tagName","button",searchForm);

//▓ Clicking on search box
        searchBox.click();

//▓ Entering searched text
        searchBox.sendKeys(text);

//▓ Clicking on search button
        searchBoxBtn.click();

        WebElement results = SWS("id","post_container");
        List<WebElement> articles = ToListOfWEBy("className","entry",results);

        WebElement rndArticle;

        if(articles.size()!=0)
        {
            int rndNumber = (int) (Math.random() * (articles.size()));
            if(rndNumber!=0) {
                scrollToElement(articles.get(rndNumber - 1));
            }
            else {
                scrollToElement(driver.findElement(By.id("breadcrumb")));
            }
            rndArticle = articles.get(rndNumber);

//▓ Clicking on random article
            WebElement articleTitle = SWS("className","entry_title",rndArticle).findElement(By.tagName("a"));
            articleTitle.click();
        }
        else {
            System.out.println("Nema članaka za zadati parametar pretrage!");
        }
    }

    public static boolean checkingTextOnArticle(String text,WebElement element) {
        boolean result=false;

        result = Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE).matcher(element.getText()).find();

        if(!result)
        {
            if(isExists("tagName","a",element)) {
                List<WebElement> links = element.findElements(By.tagName("a"));
                for (WebElement link : links)
                {
                    result = Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE).matcher(link.getAttribute("href")).find();
                    if(result) System.out.println("Traženi pojam se sakrio negde u linku! - "+link.getAttribute("href"));
                }
            }
        }

        return result;
    }
}
