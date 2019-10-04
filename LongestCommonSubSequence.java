import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int size= s2.length();
        int[][] lcm = new int[size+1][size+1];

        for(int i=1;i<=size;i++){
            char ch =s1.charAt(i-1);
            for(int j=1; j<=size;j++){
                if(ch==s2.charAt(j-1)){
                    lcm[i][j]=lcm[i-1][j-1]+1;
                }
                else
                    lcm[i][j] = max(lcm[i][j-1], lcm[i-1][j]);
            }
        }
        return lcm[size][size];

    }

    static int max(int i, int j){
        if(i>j)
            return i;
        return j;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
