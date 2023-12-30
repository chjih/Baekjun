package greedy;

import java.util.*;
import java.io.*;

public class _16496 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<String> queue = new PriorityQueue<>((o1,o2)->{
            if(o1.length()==o2.length()){
                return o2.compareTo(o1);
            }
            if(o1.length()<o2.length()){
                return checkA(o1,o2);
            }else{
                return checkB(o1,o2);
            }
        });

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            queue.add(st.nextToken());
        }

        // 수가 0으로 시작할 때
        if(queue.peek().equals("0")){
            System.out.println("0");
            return;
        }

        while(!queue.isEmpty()){
            System.out.print(queue.poll());
        }
    }

    static int checkA(String o1, String o2){
        for(int i=0; i<o2.length(); i+=o1.length()){
            if(i+o1.length()> o2.length()){
                return checkB(o1, o2.substring(i));
            }
            String s = o2.substring(i, Math.min(i+o1.length(), o2.length()));
            if(!s.equals(o1)){
                return s.compareTo(o1);
            }
        }
        return 0;
    }

    static int checkB(String o1, String o2){
        for(int i=0; i<o1.length(); i+=o2.length()){
            if(i+o2.length()> o1.length()){
                return checkA(o1.substring(i), o2);
            }
            String s = o1.substring(i, Math.min(i+o2.length(), o1.length()));
            if(!s.equals(o2)){
                return o2.compareTo(s);
            }
        }
        return 0;
    }
}
