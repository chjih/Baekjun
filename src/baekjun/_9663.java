package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _9663 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 어짜피 한줄에 하나만 존재 가능하기 때문에 일차원 배열로도 가능함 (2차원 배열로 하면 더 어려워짐)
    private static int[] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new int[n];
        nQueen(n, 0);
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    private static void nQueen(int n, int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            visited[depth] = i;
            if (!isVisited(depth)) {
                visited[depth] = i;
                nQueen(n, depth+1);
            }
        }
    }

    private static boolean isVisited(int depth) {
        // 열이 같으면 true 리턴
        for(int i=0; i<depth; i++){
            if(visited[depth]==visited[i]){
                return true;
            }
        }

        // 대각선에 존재하면 true 리턴
        for(int i=0; i<depth; i++){
            if(Math.abs(depth-i)==Math.abs(visited[depth]-visited[i])){
                return true;
            }
        }

        return false;
    }
}
