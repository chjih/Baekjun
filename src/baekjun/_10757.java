package baekjun;

import java.util.Scanner;

public class _10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = "";
        int al=a.length()-1, bl=b.length()-1, k=0;
        while(al!=-1&&bl!=-1){
            //끝자리 수끼리 더해서 1의 자리수만 c에 대입
            c+=(a.charAt(al)+b.charAt(bl)-'0'-'0'+k)%10;
            //끝자리 수끼리 더한 것이 1의 자리수가 넘어갈 때, 올림수 k 지정
            if((a.charAt(al--)+b.charAt(bl--)-'0'-'0'+k)>=10) k=1;
            else k=0;
        }
        //두수의 자리수가 서로 다를 때, a랑 b중 더 자리수가 큰 수를 a에 대입시킴(서로 연산하고 남은 수)
        a = (al!=-1)? a:b;
        al = (al!=-1)? al:bl;
        while(al!=-1){
            c+=(a.charAt(al)+k-'0')%10;
            if((a.charAt(al--)+k-'0')>=10) k=1;
            else k=0;
        }
        //마지막에 더한수가 올림수가 생겨 자리수가 늘어난다면, 한번 더 더해준다. ( 예) 99+1=100)
        if(k==1) c+=k;
        //1의자리부터 c에 포함되었기 때문에 뒤에서부터 출력시킴
        for(int i=c.length()-1; i>=0; i--){
            System.out.print(c.charAt(i));
        }
        sc.close();
    }
}
