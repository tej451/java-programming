package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Wsdl {
	public static void main(String arg[]){
		URL url;
		try {
			url = new URL("file://localhost/C://Shruti//webservice.wsdl");
			//url = new URL("file://UserID:password@localhost/path of dir/filename.txt");
			
			
			URLConnection connection = url.openConnection();
			System.out.println("connection -->"+connection);
			System.out.println("connection 11111-->"+connection.getURL());
			connection.setDoInput(true);
			/*String userpass = "root" + ":" + "root123";
			String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
			connection.setRequestProperty ("Authorization", basicAuth);*/
			InputStream inStream = connection.getInputStream();
			System.out.println("inStream -->"+inStream.toString());
			BufferedReader input = new BufferedReader(new InputStreamReader(
					inStream));
			String line = "";
			//monitors = new HashMap<String, String>();
			String[] str = null;
			while ((line = input.readLine()) != null){
				System.out.println("Files in the folder are -->"+line);
				/*str = line.split(":");
	    monitors.put(str[0], str[1]);
	    logger.info(str[0]+" --- "+str[1]);*/
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
