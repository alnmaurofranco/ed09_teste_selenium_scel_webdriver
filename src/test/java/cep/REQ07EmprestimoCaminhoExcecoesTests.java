package cep;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class REQ07EmprestimoCaminhoExcecoesTests {

	private WebDriver driver; 
	private Map<String, Object> vars; 
	JavascriptExecutor js; 
	
	@BeforeEach
	public void setUp() {     
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		js = (JavascriptExecutor) driver; 
		vars = new HashMap<String, Object>(); 
	} 
	
	@AfterEach 
	public void tearDown() { 
		driver.quit();
	} 

	@Test
	  public void REQ02CT07ALUNOCOM5RA() {
		driver.get("https://ts-scel.herokuapp.com/login"); 
		driver.manage().window().setSize(new Dimension(968, 728)); 
		driver.findElement(By.name("username")).click(); 
		driver.findElement(By.name("username")).sendKeys("jose"); 
		driver.findElement(By.name("password")).sendKeys("123"); 
		driver.findElement(By.cssSelector("button")).click(); 
		driver.findElement(By.linkText("Empréstimo")).click();
		espera();
		driver.findElement(By.id("isbn")).click();
	    driver.findElement(By.id("isbn")).sendKeys("8577");
	    driver.findElement(By.id("ra")).click();
	    driver.findElement(By.id("ra")).sendKeys("2045");
	    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	    assertEquals(("Livro/Aluno não localizado ou existe emprestimo em aberto"), driver.findElement(By.cssSelector(".text-danger")).getText());
	  }
	

	public void espera() { 
		try { 
			Thread.sleep(2000); 
		} 
		catch (InterruptedException e) { 
			e.printStackTrace(); 
		} 
	}

}
