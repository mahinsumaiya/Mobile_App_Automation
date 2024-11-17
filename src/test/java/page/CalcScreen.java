package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {

    @FindBy(id="com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id="com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id="com.google.android.calculator:id/op_mul")
    WebElement btnMultiply;
    @FindBy(id="com.google.android.calculator:id/op_div")
    WebElement btnDivider;
    @FindBy(id="com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id="com.google.android.calculator:id/const_pi")
    WebElement btnPI;
    @FindBy(id="com.google.android.calculator:id/op_pow")
    WebElement btnPower;
    @FindBy(id="com.google.android.calculator:id/result_final")
    WebElement txtResult;
    @FindBy(id="com.google.android.calculator:id/clr")
    public WebElement btnClear;

    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public String doSeries(String calculateSeries){

//        for (char c:calculateSeries.toCharArray()){
//            String value=String.valueOf(c);
        for (int i = 0; i < calculateSeries.length(); i++) {
            char c = calculateSeries.charAt(i);
            String value = String.valueOf(c);
            if(value.matches("\\d")){
               driver.findElement(By.id("com.google.android.calculator:id/digit_" + value)).click();
            } else if (value.equals("+")) {
                btnPlus.click();
            } else if (value.equals("-")) {
                btnMinus.click();
            }else if (value.equals("*")){
                btnMultiply.click();
            }else if (value.equals("/")){
                btnDivider.click();
            } else if (value.equals("=")) {
                btnEqual.click();
            }else {
                System.out.println("Unsupported value: "+value);
            }
        }

        btnEqual.click();
        return txtResult.getText();
    }

    public String csvFileCalculation(String expression) {
//        for (char c : expression.toCharArray()) {
//            String series = String.valueOf(c);
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            String value = String.valueOf(c);
            if (value.matches("\\d")) {
                driver.findElement(By.id("com.google.android.calculator:id/digit_" + value)).click();
            } else if (value.equals("+")) {
                btnPlus.click();
            } else if (value.equals("-")) {
                btnMinus.click();
            } else if (value.equals("*")) {
                btnMultiply.click();
            } else if (value.equals("/")) {
                btnDivider.click();
            } else if (value.equals("=")) {
                btnEqual.click();

            } else if (value.equals("p") && expression.charAt(expression.indexOf(value) + 1) == 'i') {

                btnPI.click();
                continue;
            } else if (value.equals("^")) {
                btnPower.click();
            } else {
                System.out.println("Unsupported value: " + value);  // If the value is unsupported, print it
            }
        }
        btnEqual.click();
        String result=txtResult.getText();

        if (result.contains(".")) {
            result = String.format("%.2f", Double.parseDouble(result));
        }

        return result;
    }
}






