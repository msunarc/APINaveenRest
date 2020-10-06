package GetAPiREsult;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import APIUTIL.UTILPAGE;
import BasePage.BaseApi;
import qaClient.RestCLient;

public class GetApiREsponseTest  extends BaseApi{
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
//without header
/*
 * @Test public void getApiTest() throws ClientProtocolException,IOException{
 * restclient = new RestCLient(); closeableresponse=restclient.get(url);
 * 
 * //statuscode int statuscode =
 * closeableresponse.getStatusLine().getStatusCode();
 * System.out.println("Statuscode"+statuscode); Assert.assertEquals(
 * statuscode,RESPONSE_STATUS_CODE_200,"code is not 200"); //json strin by
 * entityutils class String responseString =
 * EntityUtils.toString(closeableresponse .getEntity(),"UTF-8");
 * 
 * JSONObject responseJson = new JSONObject (responseString);
 * System.out.println("responseJson"+responseJson);
 * System.out.println("============"); //per page String
 * perpage=UTILPAGE.getValueByJpath(responseJson, "/per_page");
 * System.out.println("perpage="+ perpage); Assert.assertEquals(perpage, "6",
 * "good"); System.out.println("============"); //total String
 * total=UTILPAGE.getValueByJpath(responseJson, "/total");
 * System.out.println("total="+ total);
 * Assert.assertEquals(Integer.parseInt(total), 12, "good");
 * System.out.println("============"); //get the value from json String
 * email=UTILPAGE.getValueByJpath(responseJson, "/data[0]/email"); String
 * id=UTILPAGE.getValueByJpath(responseJson, "/data[0]/id"); String
 * first_name=UTILPAGE.getValueByJpath(responseJson, "/data[0]/first_name");
 * String last_name=UTILPAGE.getValueByJpath(responseJson,
 * "/data[0]/last_name"); System.out.println(last_name);
 * System.out.println(first_name); System.out.println("============"); //all
 * headers Header[] heardersArray = closeableresponse.getAllHeaders();
 * HashMap<String,String>allHeaders = new HashMap<String,String>();
 * 
 * for(Header header: heardersArray) {
 * allHeaders.put(header.getName(),header.getValue());
 * System.out.println("header"+allHeaders); }
 * 
 */
		 
	 
//with header
@Test
public void getApiTest() throws ClientProtocolException,IOException{
   restclient = new RestCLient();
   HashMap<String,String > headerMap= new HashMap<String,String>();
  headerMap.put("Content-Type", "application/json");
   closeableresponse=restclient.get(url);
	
 //statuscode
 	int statuscode = closeableresponse.getStatusLine().getStatusCode();
 	System.out.println("Statuscode"+statuscode);
 	Assert.assertEquals( statuscode,RESPONSE_STATUS_CODE_200,"code is not 200");
 	//json strin by entityutils class
 	String  responseString = EntityUtils.toString(closeableresponse .getEntity(),"UTF-8");
 	
 	JSONObject responseJson = new JSONObject (responseString);
 	System.out.println("responseJson"+responseJson);
 	System.out.println("============");
 	//per page
 	String perpage=UTILPAGE.getValueByJpath(responseJson, "/per_page");
 	System.out.println("perpage="+ perpage);
 	Assert.assertEquals(perpage, "6", "good");
 	System.out.println("============");
 	//total 
 	String total=UTILPAGE.getValueByJpath(responseJson, "/total");
 	System.out.println("total="+ total);
 	Assert.assertEquals(Integer.parseInt(total), 12, "good");
 	System.out.println("============");
 	//get the value from json
 	String email=UTILPAGE.getValueByJpath(responseJson, "/data[0]/email");
 	System.out.println("===========================================");
 	String id=UTILPAGE.getValueByJpath(responseJson, "/data[0]/id");
 	String first_name=UTILPAGE.getValueByJpath(responseJson, "/data[0]/first_name");
 	String last_name=UTILPAGE.getValueByJpath(responseJson, "/data[0]/last_name");
 	System.out.println(last_name);
 	System.out.println(first_name);
 	System.out.println("============");
 	//all headers
 	Header[] heardersArray = closeableresponse.getAllHeaders();
 	HashMap<String,String>allHeaders = new HashMap<String,String>();
 	
 	for(Header header: heardersArray) {
 		allHeaders.put(header.getName(),header.getValue());
 		System.out.println("header"+allHeaders);
 	}
	
	 
		 
	 }
}


