package samsungdx;

import java.io.*;
import java.util.StringTokenizer;

public class _2 {
    static int[][] columnMax;
    static int[][] rowMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            columnMax = new int[m+1][2];
            rowMax = new int[n+1][2];

            int x;
            // 초기값 입력(각각의 행/열의 최대값 저장)
            for(int j=1; j<=n; j++){
                st = new StringTokenizer(br.readLine());
                for(int l=1; l<=m; l++){
                    x = Integer.parseInt(st.nextToken());

                    if(x>columnMax[l][0]){
                        columnMax[l][0]=x;
                        columnMax[l][1]=j;
                    }
                    if(x>rowMax[j][0]){
                        rowMax[j][0]=x;
                        rowMax[j][1]=l;
                    }
                }
            }

            int backup=0;

            for(int k=1; k<=m; k++){
                if(columnMax[k][0]>=rowMax[columnMax[k][1]][0]){
                    backup++;
                }
            }

            int r,c,count=0, pre;
            // 인공위성 측정
            for(int j=0; j<q; j++){
                st = new StringTokenizer(br.readLine());

                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());

                pre=0;
                // 기존에 해당 값은 안전했는 지 확인
                // 바로 그 자리가 안전셀이였는지
                if(columnMax[c][0]==rowMax[r][0]){
                    pre++;
                }
                // 해당 행 열 에 안전셀 존재했는지
                else{
                    if(columnMax[c][0]==rowMax[columnMax[c][1]][0]){
                        pre++;
                    }
                    if(rowMax[r][0]==columnMax[rowMax[r][1]][0]){
                        pre++;
                    }
                }

                // 측정값 업데이트
                if(x>columnMax[c][0]){
                    columnMax[c][0]=x;
                    columnMax[c][1]=r;
                }
                if(x>rowMax[r][0]){
                    rowMax[r][0]=x;
                    rowMax[r][1]=c;
                }

                // 갱신된 값이 해당 셀에 영향이 갔는 지 확인
                // 변경된 셀이 안정 셀일 때
                if(columnMax[c][0]==rowMax[r][0]){
                    backup++;
                }else{
                    if(columnMax[c][0]==rowMax[columnMax[c][1]][0]){
                        backup++;
                    }
                    if(rowMax[r][0]==columnMax[rowMax[r][1]][0]){
                        backup++;
                    }
                }

                backup-=pre;
                count+=backup;
            }

            System.out.println("#"+(i+1)+" "+count);
        }
    }

//    static void print(int m, int n){
//        for(int i=1; i<=m; i++){
//            System.out.print(columnMax[i][0]+"("+columnMax[i][1]+") ");
//        }
//        System.out.println();
//
//        for(int i=1; i<=n; i++){
//            System.out.println(rowMax[i][0]+"("+rowMax[i][1]+") ");
//        }
//        System.out.println();
//    }
}
