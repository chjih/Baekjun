package money;

import java.util.*;
import java.io.*;

public class _3226 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N= Integer.parseInt(br.readLine());

        String time;
        int d, t, m, total=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            time = st.nextToken();
            d = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(time, ":");
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 경계성일때
            if(t==18||t==6){
                if(t==18){
                    // 넘어갈 때
                    if(d>60-m){
                        total+=(60-m)*10;
                        d-=60-m;
                        total+=d*5;
                    }else{
                        total+=d*10;
                    }
                }else{
                    // 넘어갈 때
                    if(d>60-m){
                        total+=(60-m)*5;
                        d-=60-m;
                        total+=d*10;
                    }else{
                        total+=d*5;
                    }
                }
            }
            else{
                if(t>=7&&t<19){
                    total+=d*10;
                }else{
                    total+=d*5;
                }
            }
        }

        System.out.println(total);
    }
}
