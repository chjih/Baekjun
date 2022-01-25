import java.util.Scanner;

public class _1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<n; i++){
            int d, a=1, count=0;
            d = -sc.nextInt()+sc.nextInt();
            //최댓값 찾아냄
            while(true){
                d -= a*2;
                if(d<0){
                    d+=a*2;
                    break;
                }
                a++;
                count+=2;
            }
            //나머지 수 집어넣어서 채움
            while(a>0){
                d-=a;
                count++;
                if(d==0) break;
                if(d<0){
                    d+=a;
                    a--;
                    count--;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
