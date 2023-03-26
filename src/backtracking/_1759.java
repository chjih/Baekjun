package backtracking;

import java.util.*;

public class _1759 {
    private static int l, c;
    private static List<Character> list = new ArrayList<>();
    private static List<Character> gather = Arrays.asList('a','e','i','o','u');

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        l = sc.nextInt();
        c = sc.nextInt();

        for(int i=0; i<c; i++){
            list.add(sc.next().charAt(0));
        }

        Collections.sort(list);
        dfs(0,"",0);

        sc.close();
    }

    private static void dfs(int cur, String result, int gatherCount){
        if(result.length()==l){
            if(gatherCount>=1&&result.length()-gatherCount>=2)
                System.out.println(result);
            return;
        }

        if(cur>=c || (gatherCount<1 && list.get(cur)>'u')){
            return;
        }

        for(int i=cur; i<c; i++){
            char c = list.get(i);
            dfs(i+1, result+c, gather.contains(c)?gatherCount+1:gatherCount);
        }
    }
}
