package com.test;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WsdlDownloader {
	
	public static void main(String arg[]){
		String content = downloadWsdl("file://localhost/C://Shruti//webservice.wsdl");
		System.out.println("Content: "+content);
	}

	public static String downloadWsdl(String urlString)
	{
		String wsdlFileContent = "";
		BufferedInputStream bis = null;
		ByteArrayOutputStream os = null;
		try
		{
			URL url = new URL( urlString);
			System.out.println(" URL -"+url);
			InputStream is = url.openStream();
			bis = new BufferedInputStream( is );
			os = new ByteArrayOutputStream();
			int oneCharacter;
			while( ( oneCharacter = bis.read() ) != -1 )
			{
				os.write( oneCharacter );
			}
			wsdlFileContent = os.toString();
		}
		catch( IOException e )
		{
			System.out.println("WsdlDownloader Exception -" +e + " wsdlFileContent - "+wsdlFileContent);
			return wsdlFileContent;
		}
		finally
		{
			try
			{
				if( bis != null )
				{
					bis.close();
				}
			}
			catch( IOException e )
			{ /* Not much to do about this I'm afraid. */
			}
			try
			{
				if( os != null )
				{
					os.close();
				}
			}
			catch( IOException e )
			{ /* Not much to do about this I'm afraid. */
			}
		}
		return wsdlFileContent;
	}
}
