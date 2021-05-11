package IBM.Assignment_SDET;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class testCase1 {
  @Test(dataProvider = "dp")
  public void postReq(String name1, String name2, String name3) {
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  JSONObject request = new JSONObject();
	  
	  request.put("application", name1); 
	  request.put("resource", name2);
	  request.put("backup", name3);
	 
	  given() 
	  	.contentType(ContentType.JSON). body(request.toJSONString())
	  	.post("/freightteam").  
	  then() 
	  	.statusCode(201).log().all();  
	  
  }

  @DataProvider(name = "dp")
  public Object[][] dp() throws IOException {
     
	  Object[][] data = utils.datautils.testdata();
	  return data;
    };
  }
