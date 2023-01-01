package baekjun;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class _18258 {
    private static int last=-1;
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            try{
                switch(s){
                    case "push":
                        last = Integer.parseInt(st.nextToken());
                        queue.offer(last);
                        break;
                    case "front":
                        bw.write(((queue.peek()==null)?-1:queue.peek())+"\n");
                        break;
                    case "back":
                        if(queue.isEmpty()) bw.write("-1\n");
                        else bw.write(last+"\n");
                        break;
                    case "size":
                        bw.write(queue.size()+"\n");
                        break;
                    case "empty":
                        if(queue.isEmpty()) bw.write("1");
                        else bw.write("0");
                        bw.newLine();
                        break;
                    case "pop":
                        bw.write(((queue.peek()==null)?-1:queue.poll())+"\n");
                        break;
                }
            } catch (EmptyStackException e){
                System.out.println("-1");
            }
        }
        bw.flush();
        bw.close();
    }
}
