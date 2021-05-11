package IBM.Assignment_SDET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class testCase2 
{
  @Test()
  public void f() throws IOException 
  {
  
	  FileInputStream fis = new FileInputStream(".\\testData\\multibody.xml");
	  RestAssured.baseURI="http://www.dneonline.com";
	  Response res = given().
			  		headers("content-type","text/xml").
			  		body(IOUtils.toString(fis, "UTF-8")).
			  		post("/calculator.asmx").
			  		then().
			  		statusCode(200).
			  		log().all().extract().response();
			  
	  
	  XmlPath obj  = new XmlPath(res.asString());
	  String actual = obj.getString("MultiplyResult");
	  
	  Assert.assertEquals("75", actual);
	  
  }
  }

