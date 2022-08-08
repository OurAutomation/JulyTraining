package arrays;

import washingTon.Car;

public class Testing {
    public static void main(String[] args) {
        int i=10;
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
        System.out.println(twoDimArr[0][2]);
        int[][][] threeDimArr = new int[2][6][7];
        threeDimArr[0] = twoDimArr;

        String[] strArr = new String[2];
        strArr[0]="Flag";
        strArr[1]="India";

        Car[] carr = new Car[2];
        carr[0] = new Car("BMW");
        carr[1] = new Car("ferrari");

        carr[0].steer();
        carr[1].drive();
    }
}
