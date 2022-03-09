package com.letskodeit.test;

import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.pageclass.CategoryFilterPage;
import com.letskodeit.pageclass.NavigationPage;
import com.letskodeit.pageclass.SearchBarPage;
import com.letskodeit.utilities.Constants;
import com.letskodeit.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AllCoursesTest extends BaseTest {

    @DataProvider(name = "verifySearchCourseData")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("verify_search_course");
        return testData;
    }

    @BeforeClass
    public void setUP(){
       lg.signIN(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");

    }
    @Test(dataProvider = "verifySearchCourseData")
    public void verifySearchCourses(String courseName) throws InterruptedException {

        nav.click_AllCoursesTab();
        sb = new SearchBarPage(driver);
        rs = sb.search_Courses(courseName);
        Boolean val = rs.verifySearchResult();
        CheckPoint.markFinal("test-02", val, "search course verification");
    }

@Test(enabled = false)
    public void filterByCategory() throws InterruptedException {
        nav=new NavigationPage(driver);
        nav.click_AllCoursesTab();
        category = new CategoryFilterPage(driver);
        category.select("Sofware Testing");
        int count = category.findCoursesCount("Sofware Testing");
        Assert.assertEquals(1,count);

        }

    @AfterClass
    public void tearDown(){


    }


}
