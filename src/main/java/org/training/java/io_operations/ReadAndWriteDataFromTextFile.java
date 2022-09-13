package org.training.java.io_operations;

import java.io.*;

public class ReadAndWriteDataFromTextFile {
    public static void main(String[] args) throws IOException {
        String project_home = System.getProperty("user.dir");
        BufferedReader reader = new BufferedReader(new FileReader(project_home + File.separator + "ABC.txt"));
        /*System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());
        System.out.println(reader.readLine());*/

        File outputFile = new File(project_home + File.separator + "123.txt");
        if (outputFile.exists()) { //Will check if file exists or not
            outputFile.delete();// Will delete the file
        }
        outputFile.createNewFile(); // will create a new file
        FileWriter fileWriter = new FileWriter(outputFile);
        boolean addLineInTheTop = false;
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (!addLineInTheTop) {
                fileWriter.write(line);
                addLineInTheTop=true;
            } else {
                fileWriter.write("\n" + line);
            }
        }
        fileWriter.close();
    }
}
