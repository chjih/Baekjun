package backtracking;

import java.util.*;

public class _1182 {
    private static List<Integer> list = new ArrayList<>();
    private static int count=0;
    private static int n, s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        sum(0, 0);

        System.out.println(count);
    }

    private static void sum(int cur, int result) {
        if(result==s && cur!=0){
            count++;
        }

        if(cur>=n || (list.get(cur)>0&&s<result)){
            return;
        }

        for(int i=cur; i<n; i++){
            sum(i+1, result+list.get(i));
        }
    }
}
