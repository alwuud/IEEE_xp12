import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static String cutTheSticks(int[] arr) {
        int min=1001;
        int contador=0;
        String arreglo="";
        while(true){
            min=1001;
            contador=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>0){
                    min= (arr[i]<min)? arr[i]: min;
                }
            }
            if(min==1001)
                break;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>0){
                    arr[i]-= min;
                    contador++;
                }
            }
            
            arreglo+= contador + ",";
            
            
            
        }
        return arreglo;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        String result = cutTheSticks(arr);
        String [] res= result.split(",");

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
