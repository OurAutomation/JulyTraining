package exceptionHandling;

import java.io.*;

public class ArithmeticOperations {
    public int divide(int i, int j) {
        try {
            return i / j;
        } catch (ArithmeticException exception) {
            return 0;
        } finally {

        }
    }

    public void readFromAFile(File file) throws IOException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            System.out.println("Input stream is opened");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;
            if (s == null)
                throw new TrainingException("Exception thrown");
            do {
                System.out.println(s.split(",")[0]);
            } while ((s = reader.readLine()) != null);

        } catch (TrainingException e) {
            System.out.println(e.getStackTrace());
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //set of statements
        } catch (Exception e) {

        } finally {
            System.out.println("input stream is closed");
            inputStream.close();
        }

    }
}
