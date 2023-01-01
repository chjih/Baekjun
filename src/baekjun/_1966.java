package baekjun;

import java.util.*;

public class _1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int k = sc.nextInt();
            Integer[] ar = new Integer[k];
            int index = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for(int j=0; j<k; j++){
                ar[j]=sc.nextInt();
                queue.offer(ar[j]);
            }
            Arrays.sort(ar);
            int c=0;
            while(k>=1){
                int max = ar[--k];
                while(true){
                    if(queue.peek()==max){
                        queue.poll();
                        if(index==0) System.out.println(c+1);
                        index--;
                        c++;
                        break;
                    }else{
                        queue.offer(queue.poll());
                        if(index==0) index = k;
                        else index--;
                    }
                }
            }

        }
        sc.close();
    }
}
