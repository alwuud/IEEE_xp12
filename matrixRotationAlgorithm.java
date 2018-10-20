import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        Integer temp=0;
        int limite= Math.min(matrix.size(), matrix.get(0).size());
        for(int d=0; d<r;d++)
        for(int i=0; i<limite/2; i++){
            int iteraciones= r%((matrix.size()-i)*2 +(matrix.get(i).size() -i)*2 -4);
            //for(int f=0; f<iteraciones;f++){
                
                  temp= matrix.get(i).get(i);
            for(int j=i; j< matrix.get(i).size()-i-1; j++){
                matrix.get(i).set(j, matrix.get(i).get(j+1)) ;
            }
            for(int j=i; j< matrix.size()-i-1; j++){
                matrix.get(j).set( matrix.get(i).size()-i-1, matrix.get(j+1).get( matrix.get(i).size()-i-1 )) ;
                
                
            }
            
            
            for(int j=matrix.get(i).size()-i-1; j>i; j--){
                matrix.get(matrix.size()-i-1).set(j,matrix.get(matrix.size()-i-1).get(j-1))  ;
            }
            
            for(int j=matrix.size()-i-1; j>i; j--){
                matrix.get(j).set(i, matrix.get(j-1).get(i)) ;
            }
            matrix.get(i+1).set(i, temp);
            
            //}
        
            
        }
        
        for(int i=0; i< matrix.size(); i++){
                for(int j=0; j<matrix.get(i).size(); j++){
                    System.out.print(matrix.get(i).get(j) + " ");
                    
                }
                System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
