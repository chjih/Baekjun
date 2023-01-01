package baekjun;

import java.io.*;
import java.util.StringTokenizer;

public class _5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String p = br.readLine();
            //배열의 길이 : n
            int n = Integer.parseInt(br.readLine());
            int front=0, rear=n-1;
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            int[] ar = new int[n];
            for(int j=0; j<n; j++){
                ar[j] = Integer.parseInt(st.nextToken());
            }
            //명령어 입력
            try{
                int k=1;
                for(int j=0; j<p.length(); j++){
                    char s = p.charAt(j);
                    switch(s){
                        case 'R':
                            k*=-1;
                            break;
                        case 'D':
                            n--;
                            if(k==1){
                                ar[front++]=0;
                            }
                            else{
                                ar[rear--]=0;
                            }
                            break;
                        default:
                            break;
                    }
                }
                bw.write("[");
                if(k==1){
                    for(int j=0; j<ar.length; j++){
                        if(ar[j]!=0){
                            n--;
                            bw.write(String.valueOf(ar[j]));
                            if(n!=0) bw.write(",");
                        }
                    }
                }
                else{
                    for(int j=ar.length-1; j>=0; j--){
                        if(ar[j]!=0){
                            n--;
                            bw.write(String.valueOf(ar[j]));
                            if(n!=0) bw.write(",");
                        }
                    }
                }
                bw.write("]\n");
            } catch(ArrayIndexOutOfBoundsException e){
                bw.write("error\n");
            }

        }

        bw.flush();
        bw.close();
    }
}
