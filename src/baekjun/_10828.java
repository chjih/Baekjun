package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _10828 {
    private static int[] array;
    private static int top=0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        array=new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            String o = st.nextToken();
            switch(o){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    bw.write(top+"\n");
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
            bw.flush();
        }
    }

    public static void push(int x){
        array[top++] = x;
    }

    public static void pop() throws IOException {
        if(top>0){
            bw.write(array[--top]+"\n");
            return;
        }
        bw.write(-1+"\n");
    }

    public static void empty() throws IOException{
        if(top==0){
            bw.write(1+"\n");
            return;
        }
        System.out.println(0);
    }

    public static void top() throws IOException{
        if(top>0){
            bw.write(array[top-1]+"\n");
            return;
        }
        bw.write(-1+"\n");
    }
}
