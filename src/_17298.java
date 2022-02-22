import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            array[i]=Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i=1;
        while(i<=array.length){
            if(i==array.length){
                if(stack.size()>0) {
                    array[stack.pop()]=-1;
                } else{
                    break;
                }
            }
            else if(stack.size()>0&&array[stack.peek()]<array[i]){
                array[stack.peek()]=array[i];
                stack.pop();
            } else{
                stack.add(i);
                i++;
            }
        }
        for(i=0; i<array.length; i++){
            bw.write(array[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
