import java.util.Scanner;

public class _2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min=0, hap=0;
        a += (a==1)?1:0;
        boolean check=false;
        for(int i=a; i<=b; i++){
            for(int j=2; j<i; j++){
                if(i%j==0){
                    check=true;
                    break;
                }
            }
            if(!check){
                min=(min==0)?i:min;
                hap+=i;
            }
            check=false;
        }
        if(min!=0){
            System.out.println(hap);
            System.out.println(min);
        } else System.out.println("-1");
        sc.close();
    }
}
