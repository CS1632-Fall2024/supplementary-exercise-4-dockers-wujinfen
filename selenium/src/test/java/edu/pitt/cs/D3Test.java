// Generated by Selenium IDE

package edu.pitt.cs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import java.time.Duration; //RW: maybe dont need
import org.openqa.selenium.chrome.ChromeOptions;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class D3Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
 
  @Test
  public void tEST1LINKS() {
    /* 
    driver.get("http://localhost:8080");
    WebElement element = driver.findElement(By.cssSelector("a[href=\'/reset\']"));
    String attribute = element.getAttribute("href");
    vars.put("res", attribute);
    assertEquals(vars.get("res").toString(), "/reset");
    */

    driver.get("http://localhost:8080");
    
    WebElement element = driver.findElement(By.xpath("/html/body/div/header/nav/ul/li[8]/a"));
    String hrefVal = element.getAttribute("href");
    assertEquals("http://localhost:8080/reset", hrefVal);
  }
  @Test
  public void tEST2RESET() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.cssSelector(".form-group:nth-child(3)")).click();
    driver.findElement(By.id("rentID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("3");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.linkText("Reset")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST3CATALOG() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Catalog")).click();
    {
      WebElement element = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/ol/li[2]/img"));
      String attribute = element.getAttribute("src");
      attribute = attribute.replace("http://localhost:8080", "");
      vars.put("src", attribute);
    }
    assertEquals("/images/cat2.jpg",vars.get("src").toString());
  }
  @Test
  public void tEST4LISTING() {
    driver.get("http://localhost:8080");
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div/ul/li[3]"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div/ul/li[4]"));
      assert(elements.size() == 0);
    }
    assertThat(driver.findElement(By.xpath("//div/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
  }
  @Test
  public void tEST5RENTACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'rentSubmit()\']"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button[@onclick=\'returnSubmit()\']"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST6RENT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("1");
    driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div[3]/button")).click();
    assertThat(driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[1]/ul/li[1]")).getText(), is("Rented out"));
    assertThat(driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[1]/ul/li[2]")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[1]/ul/li[3]")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("rentResult")).getText(), is("Success!"));
  }

  @Test
  public void tEST7RETURN() {
    //js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");
    driver.get("http://localhost:8080");
    driver.manage().window().setSize(new Dimension(1512, 750));
    js.executeScript("document.cookie = \"1=false\";document.cookie = \"2=false\";document.cookie = \"3=false\";");

    driver.findElement(By.linkText("Rent-A-Cat")).click();
    driver.findElement(By.id("rentID")).click();
    driver.findElement(By.id("rentID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(3) .btn")).click();
    driver.findElement(By.id("returnID")).click();
    driver.findElement(By.id("returnID")).sendKeys("2");
    driver.findElement(By.cssSelector(".form-group:nth-child(4) .btn")).click();
    assertThat(driver.findElement(By.id("cat-id1")).getText(), is("ID 1. Jennyanydots"));
    assertThat(driver.findElement(By.id("cat-id2")).getText(), is("ID 2. Old Deuteronomy"));
    assertThat(driver.findElement(By.id("cat-id3")).getText(), is("ID 3. Mistoffelees"));
    assertThat(driver.findElement(By.id("returnResult")).getText(), is("Success!"));
  }
  @Test
  public void tEST8FEEDACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//button"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void tEST9FEED() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Feed-A-Cat")).click();
    driver.findElement(By.id("catnips")).click();
    driver.findElement(By.id("catnips")).sendKeys("6");
    driver.findElement(By.cssSelector(".btn")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'feedResult\' and contains(text(),\'Nom, nom\')]")));
    }
    assertThat(driver.findElement(By.id("feedResult")).getText(), is("Nom, nom, nom."));
  }
  @Test
  public void tEST10GREETACAT() {
    driver.get("http://localhost:8080");
    driver.findElement(By.linkText("Greet-A-Cat")).click();
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow!Meow!Meow!"));
  }
  @Test
  public void tEST11GREETACATWITHNAME() {
    driver.get("http://localhost:8080/greet-a-cat/Jennyanydots");
    assertThat(driver.findElement(By.cssSelector("#greeting > h4")).getText(), is("Meow! from Jennyanydots."));
  }
}