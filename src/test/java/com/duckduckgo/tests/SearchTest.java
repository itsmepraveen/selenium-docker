package com.duckduckgo.tests;

import com.base.BaseTest;
import com.duckduckgo.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchAndCountVideos(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goToURL();
        searchPage.enterSearchKeyword(keyword);
        int noOfVideos = searchPage.countNoOfVideos();
        Assert.assertTrue(noOfVideos>0);
    }


}
