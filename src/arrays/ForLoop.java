package arrays;

public class ForLoop {
    public static void main(String[] args) {
        int[] a = new int[5];
        a[0]=12;
        a[1]=13;
        a[2]=344;
        a[3]=34243;
        a[4]=13232;
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }

        /*for (int i=a.length-1;i>=0;i--) {
            System.out.println(a[i]);
        }*/

        int i=a.length-1;
        while(i>=0) {
            System.out.println(a[i--]);
        }
    }
}
