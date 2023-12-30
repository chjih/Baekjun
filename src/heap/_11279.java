package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _11279 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int x;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            x = sc.nextInt();

            if(x==0){
                if(maxHeap.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(maxHeap.poll());
                }
            } else{
                maxHeap.add(x);
            }
        }

        sc.close();
    }
}
