import java.util.Scanner;

public class _1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int gap, r, cout=0;
        boolean bool;
        //두자리 수는 무조건 한수
        if(n<=99) cout+=n ;
        //세자리 수부터 검사
        else{
            cout+=99;
            for(int i=100; i<=n; i++){
                r = i;
                bool = true;
                gap = (r-r%10)/10%10-r%10;
                do {
                    //이전의 차수와 현재 차수가 다르다면 false값을 가지고 반복문 빠져나감
                    if(gap!=(r-r%10)/10%10-r%10){
                        bool = false;
                        break;
                    }
                    r = (r-r%10)/10;
                }while(r>=10);      //do~while문이라 r이 10보다 크거나 같아야한다.
                //false를 가지고 빠지지 않았을 시 한수
                if(bool==true){
                    cout++;
                }
            }
        }
        System.out.println(cout);
        sc.close();
    }
}
