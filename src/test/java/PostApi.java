import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BasePage.BaseApi;
import qa.data.Users;
import qaClient.RestCLient;

public class PostApi  extends BaseApi{
	
	BaseApi Basepage;
	String serviceUrl;
	String apiUrl;
	String url;
	RestCLient restclient;
	CloseableHttpResponse closeableresponse;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException,IOException{
		 Basepage= new BaseApi() ;
		 serviceUrl=prop.getProperty("URL");
		 apiUrl=prop.getProperty("serviceURL");
		 
		 url=  serviceUrl+apiUrl;
		 	 
	}
@Test
 public void postApiTest() throws JsonGenerationException, JsonMappingException, IOException {
	restclient=new RestCLient();
	HashMap<String,String> headerMap=new HashMap<String,String>();
	headerMap.put("Content-Type", "application/json");

ObjectMapper mapper=new ObjectMapper();
Users user=new Users("morpheus","leader","785","2020-10-04T03:13:42.324Z");
	
//object to jason==at file
mapper.writeValue(new File("\\Users\\msuna\\eclipse-workspace\\NAveenAPI_GET\\src\\main\\java\\qa\\data\\users.json"), user);

//object to String==at console
String UserASString =mapper.writeValueAsString(user);//excepted user
System.out.println(UserASString);

//POST call: return closeable http response

closeableresponse=restclient.post(url,UserASString,headerMap);

//checkstatuscode
int code=closeableresponse.getStatusLine().getStatusCode();
System.out.println(code);
//Assert.assertEquals( code, BaseApi.RESPONSE_STATUS_CODE_201);

//
//  //JsonString

String responsJsonSTRing=EntityUtils.toString(closeableresponse.getEntity(),"UTF-8");
 JSONObject responseJson= new JSONObject(responsJsonSTRing);  System.out.println("response in json"+ responseJson);  //jason -object

//Users userobje=mapper.readValue(responsJsonSTRing, Users.class);
//System.out.println(userobje);//actual user
 
// Assert.assertTrue(user.getName().equals(userobje).getName()));
 //Assert.assertTrue(user.getName().equals(userobje).getName()));










}
}