import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int tam= arr.length;
        long sum=0;
        long min=-1, max= 0;
        for(int i=0; i< tam; i++){
            for(int j=0; j<tam; j++){
                sum+= (j != i) ? arr[j] : 0;
                
            }
            if(min>0)
                min= (sum<min) ? sum: min;
            else    
                min = sum;
            max= (sum>max) ? sum: max;
            sum=0;
        }
        System.out.println(min + " " + max);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}