package com.serialization;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SerializeToXML 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
        UserSettings settings = new UserSettings();
        settings.setFieldOne(10000);
        settings.setFieldTwo("HowToDoInJava.com");
        settings.setFieldThree(false);
        settings.setFieldFour("shruti");
         
        //Before
        System.out.println(settings);
        serializeToXML ( settings );
        settings.setFieldFour("shruti singh");
        UserSettings loadedSettings = deserializeFromXML();
        //After
        System.out.println(loadedSettings);
    }
     
    private static void serializeToXML (UserSettings settings) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("settings.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
                public void exceptionThrown(Exception e) {
                    System.out.println("Exception! :"+e.toString());
                }
        });
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }
     
    private static UserSettings deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("settings.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        UserSettings decodedSettings = (UserSettings) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }
    
   
}
