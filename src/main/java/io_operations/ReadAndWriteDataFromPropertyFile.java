package io_operations;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.SimpleTimeZone;

public class ReadAndWriteDataFromPropertyFile {
    public static void main(String[] args) throws IOException {
        String project_home = System.getProperty("user.dir");
        String propertyFilePath = project_home+ File.separator+"address.properties";
        FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
        Properties addressProperties = new Properties();
        addressProperties.load(fileInputStream);
        System.out.println(addressProperties.getProperty("d.no"));
        System.out.println(addressProperties.getProperty("state"));
        System.out.println(addressProperties.getProperty("city"));
        System.out.println(addressProperties.getProperty("country"));
        System.out.println(addressProperties.getProperty("landmark"));
        SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss");
        addressProperties.setProperty("lastChecked",sdf.format(new Date()));
        FileOutputStream outputStream = new FileOutputStream(propertyFilePath);
        addressProperties.store(outputStream,"");
        outputStream.close();
    }
}
