package binarysearch;

import java.util.*;

public class _1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(sc.nextInt());
        }

        n = sc.nextInt();

        for(int i=0; i<n; i++){
            if(set.contains(sc.nextInt())){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }


        sc.close();
    }
}
