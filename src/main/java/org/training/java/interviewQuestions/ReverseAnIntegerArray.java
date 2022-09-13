package org.training.java.interviewQuestions;

public class ReverseAnIntegerArray {
    static int[] arr1 = new int[]{1,2,3,4,65,67};
    static int[]arr2 = new int[arr1.length];

    public static void main(String[] args) {
        int j=0;
        for(int i=arr1.length-1;i>=0;i--) {
            arr2[j]=arr1[i];
            j++;
        }
        for (j=0;j< arr2.length;j++) {
            System.out.println(arr2[j]);
        }
    }
}
