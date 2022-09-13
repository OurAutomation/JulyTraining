package org.training.java.arrays;

public class Practice {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0]=12;
        a[1]=13;
        a[2]=344;
        a[3]=34243;
        a[4]=13232;
        /*System.out.println(a[0]);
        System.out.println(a[3]);*/
        int[] arr = new int[] {1,22,3,4,45,5};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println("Number of elements present in the array :: " + arr.length);
        int[][] twoDimArr = new int[2][6];
        twoDimArr[0]=a;
        twoDimArr[1]=arr;

        int lengthOfTheTwoDimensionalArray = twoDimArr.length;
        int lengthOfFirstSingleDimensionalArray = twoDimArr[0].length;
        int lengthOfSecondSingleDimensionalArray = twoDimArr[1].length;
    }
}
