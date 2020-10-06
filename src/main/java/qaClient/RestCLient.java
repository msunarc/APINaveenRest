package qaClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestCLient {

	//1. Getmethod
	
	public CloseableHttpResponse get(String url) throws ParseException, IOException {
		//create client connection
		//class will return closehttpclient object
	CloseableHttpClient httpClient =HttpClients.createDefault();
		//create get connection
	HttpGet httpget = new HttpGet(url);
	// will execute ur requestn store in variable
	CloseableHttpResponse closeableresponse = httpClient.execute(httpget);
	return closeableresponse;
	}
	
	
	
	// Validate with header in request

	public CloseableHttpResponse get(String url, HashMap<String,String>headerMap) throws ParseException, IOException {
		//create client connection
		//class will return closehttpclient object
	CloseableHttpClient httpClient =HttpClients.createDefault();
		//create get connection
	HttpGet httpget = new HttpGet(url);
	
	for(Entry<String, String> entry: headerMap.entrySet()) {
		httpget.addHeader(entry.getKey(),entry.getValue());
	}
	// will execute ur requestn store in variable
	CloseableHttpResponse closeableresponse = httpClient.execute(httpget);
	return closeableresponse;
	}
	
	//POST METHod
	public CloseableHttpResponse post (String url,String entityString,HashMap<String,String>headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient =HttpClients.createDefault();
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new StringEntity(entityString));
	//header		
			for(Entry<String, String> entry: headerMap.entrySet()) {
				httppost.addHeader(entry.getKey(),entry.getValue());
			}
			CloseableHttpResponse closeableresponse=httpClient.execute(httppost);
			return closeableresponse;
			}
			
	}
	
	
	
	/*
	 * //statuscode int statuscode =
	 * closeableresponse.getStatusLine().getStatusCode();
	 * System.out.println("Statuscode"+statuscode); //json strin by entityutils
	 * class String responseString = EntityUtils.toString(closeableresponse
	 * .getEntity(),"UTF-8"); JSONObject responseJson = new JSONObject
	 * (responseString); System.out.println("responseJson"+responseJson); //all
	 * headers Header[] heardersArray = closeableresponse.getAllHeaders();
	 * HashMap<String,String>allHeaders = new HashMap<String,String>();
	 * 
	 * for(Header header: heardersArray) {
	 * allHeaders.put(header.getName(),header.getValue());
	 * System.out.println("header"+allHeaders); }
	 */
	
	
	
	

