import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes=0;
        // Creating array of initial positions
        int[] position =new int[q.length];
        for(int i=0;i<q.length;i++){
            position[i]=i+1;
        }
        for(int i=0;i<q.length;i++){
            int bribe=0;
            int index=0;
            //finding the new position after bribing
            if(q[i]!=position[i]){
                for(int x=i+1;x<q.length;x++){
                        if(position[x]==q[i]){
                            index=x;
                            x=q.length;
                        }
                        
                    }
            }
            //Bribing
            while(q[i]!=position[i]){
                 position[index-bribe]=position[index-bribe-1];
                 position[index-bribe-1]=q[i];
                 bribe++;
                
            }
            if(bribe>2){
                System.out.println("Too chaotic");
                return;
                }
            bribes+=bribe;
            }
          System.out.println(bribes);  
        }

        

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
