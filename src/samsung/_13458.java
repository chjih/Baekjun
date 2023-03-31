package samsung;

import java.util.*;

public class _13458 {
    private static int n;
    private static long count;
    private static int[] classes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        count=0;
        classes = new int[n];

        for(int i=0; i<n; i++){
            classes[i] = sc.nextInt();
        }

        int b = sc.nextInt();
        int c = sc.nextInt();

        for(int i=0; i<n; i++){
            classes[i]-=b;
            if(classes[i]<0)
                classes[i]=0;
            count++;
            count(c, classes[i]);
        }

        System.out.println(count);

        sc.close();
    }

    private static void count(int c, int people){
        int x = (people+c-1)/c;
        count+=x;
    }
}
