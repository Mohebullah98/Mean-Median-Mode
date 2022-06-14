import java.io.*;
import java.util.*;

public class Solution {
    
    public static void mmm(int N,int [] arr){
        int total =0;
        int mode = arr[0];
        int maxCount = 0;
        HashMap <Integer,Integer> numbers = new HashMap<Integer,Integer>();
        for(int i=0;i<N;i++){
            int num= arr[i];
            total+=num;
            if(numbers.get(num)!=null){
                int count = numbers.get(num);
                numbers.put(num,count+1);
            }
            else{
                numbers.put(num,1);
            }
        }
        //mode is the value with highest count, and smaller value if count==maxCount
        for(Map.Entry<Integer,Integer> entry:numbers.entrySet()){
            if(entry.getValue()>maxCount || (entry.getValue()==maxCount && entry.getKey()<mode)){
                maxCount=entry.getValue();
                mode=entry.getKey();
            }
        }
        //mean is total of array divided by length
        double mean = (double) total/N;
        Arrays.sort(arr);
        //median is middle value of sorted array, average of 2 middle values if array is even in length
        double median = arr.length%2==0 ? (double)(arr[arr.length/2-1]+arr[arr.length/2])/2.0 : arr[arr.length/2];
        System.out.print(mean +"\n" +median +"\n"+mode);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Arr[] = new int[N];
        int index=0;
        while(s.hasNext()){
            Arr[index] = s.nextInt();
            index++;
        }
        s.close();
        mmm(N,Arr);
    }
}
