# QA-Automation

▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
Automation tests for a site for IT job ads, IT columns and IT companies - "https://www.helloworld.rs/" and tests fo Log In on-site - "https://www.winwin.rs/"
----------------------------------------------------------------------------
The project contains 2 parts:
	I 	Positive/Negative Log In tests on-site - "https://www.winwin.rs/"
	II	Test of site's 3 functionality of the site - "https://www.helloworld.rs/"
  
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

▓I 	Positive/Negative Log In tests on-site - "https://www.winwin.rs/"
----------------------------------------------------------------------------
This part of the project contains:
	1) Positive Log In test on-site - "https://www.winwin.rs/"
	2) Negative Log In test on-site - "https://www.winwin.rs/"

▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓II	  Test of site's 3 functionality - Search for job ads, search for the company, and search for the IT news and articles
----------------------------------------------------------------------------
This part of the project includes main tests ie tests for site "www.helloworld.rs":
	1.	searchingForJobAdsTest
	2.	searchingForCompany
	3.	searchingForArticleInITColumn

1. Test - searchingForJobAdsTest
----------------------------------------------------------------------------
The task of this test is to check the main function of the site ie searching for job ads.

Through this section, users could search for job ads by desirable technologies, cities, and seniority.

The test includes job ads searchability by desired technologies, cities, and/or seniority level for any test case that includes those job ads attributes.

Test for assertation makes a list of ads, and it's moving from ad to ad and checks tags and location, mentioned in the ad, for desirable job attributes.

2. Test - searchingForCompany
----------------------------------------------------------------------------
The task of this test is to check the company search on the site section "IT Insajder".

Through this section, companies can be searchable by company name and company city.

At the beginning of the test, define wanted attributes to search by. 
If you insert company name, the test will execute the search company by company name, enter on her profile page and check is it wanted company.

Note: There are two types of company pages. First, normal, made as profile page with sections as separate web pages, and second, advanced, which one includes one-page profile page which includes in it all sections from normal/regular page.

If on other hand, you insert the city for searching, the test will execute search companies by the city as he'll search companies by their location, it will select some random company from the results of a search, enter on her profile page, and check her location. 

Note: The location of the company could be on multiple places and sections of the company page.

3. Test - searchingForArticleInITColumn
----------------------------------------------------------------------------
The task of this test is to check the article search on the site section "IT Kolumna".

Through this section, visitors could search for articles, that are published by the site, about events in IT society.

The test includes execution of the search by the term, makes the list of result articles, choose one randomly, enters in it, and check the whole content of the article is it contains given term.

Note: Searched terms could be found embedded into links.
