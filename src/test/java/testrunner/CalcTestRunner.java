package testrunner;

import config.SeriesDataSet;
import config.SetUp;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import page.CalcScreen;



    public class CalcTestRunner extends SetUp {
        CalcScreen calcScreen;

        @Test(priority = 1, description = "Calculating a series")
        public void calculate() {
            calcScreen = new CalcScreen(driver);
            String result=calcScreen.doSeries("100/10*5-10+60");

            System.out.println(result);
            Assert.assertEquals(result,"100","Result is correct!");

        }

        @Test(priority = 2,dataProvider = "SeriesDataSet",dataProviderClass = SeriesDataSet.class,description ="Calculate Series from CSV file" )
        public void csvFileSeries(String expression,String expected_result){
            calcScreen=new CalcScreen(driver);
            String csvResult=calcScreen.csvFileCalculation(expression);
            System.out.println(csvResult);
            Assert.assertEquals(csvResult,expected_result);
        }
        @AfterMethod
        public void clear(){
            calcScreen=new CalcScreen(driver);
            calcScreen.btnClear.click();
        }




    }




