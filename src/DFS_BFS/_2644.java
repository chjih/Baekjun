package DFS_BFS;

import java.util.*;
import java.util.Scanner;

public class _2644 {
    private static int[] visited;
    private static int[] person;
    static int A, B, aD, bD;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        A = sc.nextInt();
        B = sc.nextInt();

        int m = sc.nextInt();
        person = new int[n+1];
        visited = new int[n+1];

        int a,b;
        for(int i=0; i<m; i++){
            a=sc.nextInt();
            b=sc.nextInt();

            person[b]=a;
        }

        Map<Integer, Integer> parent = new HashMap<>();

        int cur=1;

        parent.put(A, 0);
        while(person[A]!=0){
            parent.put(person[A], cur++);
            A = person[A];
        }

        cur=0;
        while(B!=0){
            if(parent.containsKey(B)){
                System.out.println(parent.get(B)+cur);
                return;
            }

            cur++;
            B = person[B];
        }

        System.out.println(-1);
    }
}
