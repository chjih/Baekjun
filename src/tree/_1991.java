package tree;

import java.util.Scanner;

public class _1991 {
    private static int n;
    private static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tree = new int[n + 1][2];

        int r, m, l;
        for (int i = 0; i < n; i++) {
            m = sc.next().charAt(0);
            l = sc.next().charAt(0);
            r = sc.next().charAt(0);


            tree[m - 'A'][0] = r;
            tree[m - 'A'][1] = l;
        }

        pre('A');
        System.out.println();
        inorder('A');
        System.out.println();
        post('A');
        System.out.println();

        sc.close();
    }

    static void pre(int m) {
        if(m=='.'){
            return;
        }
        System.out.print((char)m);
        pre(tree[m - 'A'][1]);
        pre(tree[m - 'A'][0]);
    }

    static void inorder(int m) {
        if(m=='.'){
            return;
        }

        inorder(tree[m - 'A'][1]);
        System.out.print((char)m);
        inorder(tree[m - 'A'][0]);
    }

    static void post(int m) {
        if(m=='.'){
            return;
        }

        post(tree[m - 'A'][1]);
        post(tree[m - 'A'][0]);
        System.out.print((char)m);
    }
}
