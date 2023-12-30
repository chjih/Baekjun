package money;

import java.util.*;
import java.io.*;

public class _5710 {
    static int A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total, min, max, mid, a, b;
        while(true){
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(A==0&&B==0){
                break;
            }

            total = cal(A);

            min = 0;
            max = total;

            while(min<max){
                mid = (min+max)/2;
                a = price(mid);
                b = price(total-mid);

                if(Math.abs(b-a)<=B){
                    max = mid;
                }else{
                    min = mid+1;
                }
            }

            System.out.println(price(max));
        }
    }

    static int cal(int price){
        if(price<=200){
            return price/2;
        }
        if(price<=29900){
            return (price-200)/3+100;
        }
        if(price<=4979900){
            return (price-29900)/5+10000;
        }
        return (price-4979900)/7+1000000;
    }

    static int price(int m){
        if(m<=100){
            return m*2;
        }
        if(m<=10000){
            return (m-100)*3+200;
        }
        if(m<=1000000){
            return (m-10000)*5+200+29700;
        }
        return (m-1000000)*7+200+29700+4950000;
    }
}
