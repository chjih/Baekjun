package baekjun;

import java.io.*;
import java.util.*;

public class _10866 {
    //연결리스트로 덱 구현
    private static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            try{
                switch(st.nextToken()){
                    case "push_front":
                        deque.addFirst(Integer.parseInt(st.nextToken()));
                        break;
                    case "push_back":
                        deque.add(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop_front":
                        bw.write((deque.peekFirst()==null?-1:deque.poll())+"\n");
                        break;
                    case "pop_back":
                        bw.write((deque.peekLast()==null?-1:deque.pollLast())+"\n");
                        break;
                    case "size":
                        bw.write(deque.size()+"\n");
                        break;
                    case "empty":
                        if(deque.isEmpty()) bw.write("1\n");
                        else bw.write("0\n");
                        break;
                    case "front":
                        bw.write((deque.peekFirst()==null?-1:deque.peek())+"\n");
                        break;
                    case "back":
                        bw.write((deque.peekLast()==null?-1:deque.peekLast())+"\n");
                        break;
                }
            } catch(NoSuchElementException e){
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
