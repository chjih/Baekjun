package heap;

import java.util.*;

public class _11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> plusHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minusHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = sc.nextInt();
        int x, a, b;

        for(int i=0; i<n; i++){
            x=sc.nextInt();

            if(x==0){
                if(plusHeap.isEmpty()&&minusHeap.isEmpty()){
                    System.out.println(0);
                } else if(plusHeap.isEmpty()){
                    System.out.println(minusHeap.poll());
                } else if(minusHeap.isEmpty()){
                    System.out.println(plusHeap.poll());
                } else{
                    a = plusHeap.peek();
                    b = minusHeap.peek();

                    if(a==b*-1){
                        System.out.println(minusHeap.poll());
                    }else{
                        if(a>b*-1){
                            System.out.println(minusHeap.poll());
                        }else{
                            System.out.println(plusHeap.poll());
                        }
                    }
                }
            }
            else if(x>0){
                plusHeap.add(x);
            } else {
                minusHeap.add(x);
            }
        }

        sc.close();
    }
}
