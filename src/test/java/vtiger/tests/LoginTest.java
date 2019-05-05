package vtiger.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import vtiger.Config.vTigerConfig;
import vtiger.Pages.HomePage;
import vtiger.Pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	
	@BeforeClass
	public void Start()
	{
		createReport();
		launchApp();
	}
	
	
	@Test(priority=1)
	public void verifyLoginTitleTC001()
	{
		logger=report.startTest("verifyLoginTitleTC001");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.verifyTitle();
		logger.log(LogStatus.PASS, "Title validated successfully");
		Assert.assertEquals(val, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=2)
	public void verifyLoginlogoTC002()
	{
		logger=report.startTest("verifyLoginlogoTC002");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.verifylogo();
		logger.log(LogStatus.PASS, "Logo validated successfully");
		Assert.assertEquals(val, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=3)
	public void verifyLoginInValid_TC03()
	{
		logger=report.startTest("verifyLoginInValid_TC03");
		LoginPage lp=new LoginPage(driver,logger);
		boolean val=lp.inValidlogin("dadaaa", "sadada");
		Assert.assertEquals(val, true);
		logger.log(LogStatus.PASS, "Invalid login validated successfully");
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=4)
	public void verifyLoginValid_TC04()
	{
		logger=report.startTest("verifyLoginValid_TC04");
		LoginPage lp=new LoginPage(driver,logger);
		HomePage hp=lp.login(vTigerConfig.username, vTigerConfig.pwd);
		boolean val=hp.verifyLogout();
		Assert.assertEquals(val, true);
		hp.ClickLogout();
		boolean val1=lp.verifyTitle();
		logger.log(LogStatus.PASS, "Logout validated successfully");
		Assert.assertEquals(val1, true);
		report.endTest(logger);
		report.flush();
		
	}
	
	
	@AfterClass
	public void closeapp()
	{
		tierDown();
	}

}
