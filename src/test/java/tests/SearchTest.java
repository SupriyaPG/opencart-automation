package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    public void testSearchAndAddToCart()
    {
        SearchPage searchPage=new SearchPage(driver);

        searchPage.searchProduct("MacBook");
        searchPage.openFirstProduct();

        searchPage.addToCart("2");


        Assert.assertTrue(searchPage.isProductAdded(),"Success:You have added MacBook to your shopping cart!");

    }

}
