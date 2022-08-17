package interviewQuestions;

public class ReverseAString {
    static String s = "city"; //ytic

    public static void main(String[] args) {
        String reverseString = "";
        char[] carr = s.toCharArray();
        for(int i= carr.length-1;i>=0;i--) {
            reverseString +=carr[i];
        }
        System.out.println("Reverse of the string is " + reverseString);
    }
}
