import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

  
    static String getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        String errores="";
        HashSet hs = new HashSet();
        String respuesta="";
        boolean fail=false;
        int min=101,contador=0;
        
        for(int i=0; i<b.length; i++){
            min= (b[i]< min)? b[i]:min;
            
        }
        
        
        for(int i=0; i<a.length; i++ ){
            for(int j=1; ; j++){
                fail=false;
                if(a[i]*j>min)
                    break;

                for(int k=0; k<a.length; k++){
                    if(a[i]*j % a[k] !=0){
                        fail=true;
                        
                        break;
                    }
                }
                if(fail)
                    continue;
                for(int l=0; l< b.length; l++){
               
                    if( b[l] % (a[i]*j) != 0 ){
                        fail=true;
                        errores += " " + a[i]*j;
                        break;
                    }
                }
                if(fail)
                    continue;
                
                hs.add(a[i]*j);
                respuesta= respuesta+ " " + (a[i]*j);
                
                
            }
        }
        contador= hs.size();
        return String.valueOf(contador);
        

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        String total = getTotalX(a, b);

        bw.write(total);
        bw.newLine();

        bw.close();
    }
}
