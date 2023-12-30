package greedy;

import java.util.Scanner;

public class _1541 {

    static int index=0;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int result=0, mid=0;
        char c;

        while(index<s.length()){
            c = s.charAt(index);
            if (c == '+') {
                index++;
                result+=getNumber();
            }
            else if (c == '-') {
                index++;
                mid=getNumber();
                // - 나오면 +는 계속 더한다음에 마지막으로 -해줌
                for(int j=index; j<s.length(); j++){
                    c = s.charAt(j);
                    if(c=='-'){
                        break;
                    }
                    else if(c=='+'){
                        index++;
                        mid+=getNumber();
                    }
                }
                result-=mid;
            }
            // 처음 수
            else{
                result = getNumber();
            }
        }

        System.out.println(result);

        sc.close();
    }

    static int getNumber(){
        int num=0;
        while(index<s.length()){
            char c = s.charAt(index);
            if(c=='+'||c=='-'){
                break;
            }
            num=num*10+(c-'0');
            index++;
        }
        return num;
    }
}
