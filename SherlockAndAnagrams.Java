import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int count=0;
        Hashtable<Integer, List<String>> tbl =new Hashtable<>();
        for(int i=0;i<s.length();i++){
            //getting all substrings
            List<String> subString =new ArrayList<>();
            for(int j=i+1;j<=s.length();j++){
                String str = s.substring(i,j);
                //sorting each substring 
                if(str.length()>1){
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    str = new String(chars);
                }
                //adding sorted substring into the list
                subString.add(str);
            }
            //adding List of substring in table
            tbl.put(i,subString);
        }

        for(int i=0;i<tbl.size();i++){
            //fatching sorted list from table
            List<String> subs =tbl.get(i);
            for(int j=i+1; j<tbl.size();j++){
                for(int k=0;k<subs.size();k++){
                    //checking all data in list with other lists data 
                    if(tbl.get(j).contains(subs.get(k)))
                        count++;
                }
            }
        }
        System.out.println(tbl);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
