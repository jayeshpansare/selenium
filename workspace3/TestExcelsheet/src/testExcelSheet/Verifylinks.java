package testExcelSheet;

import java.net.HttpURLConnection;
import java.net.URL;

public class Verifylinks {

	public Verifylinks(String links) {
		// TODO Auto-generated constructor stub
		
		try{
			URL url = new URL(links);
			HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
			httpurlconnection.setConnectTimeout(3000);
			httpurlconnection.connect();
			if(httpurlconnection.getResponseCode()==200){
				System.out.println("Link is :"+links+"-"+httpurlconnection.getResponseMessage());
			}
			if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println("Link is :"+links+"-"+httpurlconnection.getResponseMessage());
			}
			
		}catch(Exception e){
			System.out.println("Error is :"+e.getMessage());
		}
		
	}

}
