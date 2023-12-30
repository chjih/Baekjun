package samsungsds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2 {
    static int n, m, k, min=100000;
    static Light lights;
    static int[][] buttons;
    static Set<Light> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            lights = new Light();
            buttons = new int[m][k];
            set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lights.lights[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < k; l++) {
                    buttons[j][l] = Integer.parseInt(st.nextToken()) - 1;
                }
            }

            int count = bfs();

            System.out.println("#" + (i + 1) + " " + count);
        }
    }

    static int bfs(){
        Queue<Light> queue = new LinkedList<>();

        queue.add(new Light(lights, lights.c));
        set.add(new Light(lights, lights.c));

        while(!queue.isEmpty()){
            Light l = queue.poll();

            for(int i=0; i<m; i++){
                for(int j=0; j<k; j++){
                    push(buttons[i][j], l);
                }

                if(check(l)){
                    return l.c+1;
                }
                if(set.contains(l)){
                    continue;
                }

                set.add(new Light(l, l.c+1));
                queue.add(new Light(l, l.c+1));

                for(int j=0; j<k; j++){
                    push(buttons[i][j], l);
                }
            }
        }

        return -1;
    }

    static void print(Light l){
        for(int i=0;i<n; i++){
            System.out.print(l.lights[i]);
        }
        System.out.println();
    }

    static boolean check(Light l){
        for(int i=0; i<n; i++){
            if(l.lights[i]==0){
                return false;
            }
        }
        return true;
    }

    static void push(int index, Light l){
        if(l.lights[index]==1){
            l.lights[index]=0;
        } else{
            l.lights[index]=1;
        }
    }

    static class Light{
        int[] lights = new int[n];
        int c=0;

        public Light(){
        }

        public Light(Light light, int c){
            System.arraycopy(light.lights, 0, this.lights, 0, n);
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Light oo = (Light) obj;
            for(int i=0; i<n; i++){
                if(oo.lights[i]!=lights[i]){
                    return false;
                }
            }
            return true;
        }
    }
}