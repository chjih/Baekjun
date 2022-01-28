import java.util.Scanner;

public class _10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = "";
        int al=a.length()-1, bl=b.length()-1, k=0;
        while(al!=-1&&bl!=-1){
            c+=(a.charAt(al)+b.charAt(bl)-'0'-'0'+k)%10;
            if((a.charAt(al--)+b.charAt(bl--)-'0'-'0'+k)>=10) k=1;
            else k=0;
        }
        a = (al!=-1)? a:b;
        al = (al!=-1)? al:bl;
        while(al!=-1){
            c+=(a.charAt(al)+k-'0')%10;
            if((a.charAt(al--)+k-'0')>=10) k=1;
            else k=0;
        }
        if(k==1) c+=k;
        for(int i=c.length()-1; i>=0; i--){
            System.out.print(c.charAt(i));
        }
        sc.close();
    }
}
