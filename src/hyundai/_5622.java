package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5622 {
    static int[] num=new int['Z'-'A'+1];
    static int cost=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        putNumber('A','C',2);
        putNumber('D','F',3);
        putNumber('G','I',4);
        putNumber('J','L',5);
        putNumber('M','O',6);
        putNumber('P','S',7);
        putNumber('T','V',8);
        putNumber('W','Z',9);

        String s = bf.readLine().replace("\n", "");
        for(int i=0; i<s.length(); i++){
            cost+=num[s.charAt(i)-'A']-1+2;
        }
        System.out.println(cost);
    }

    private static void putNumber(char first, char last, int number){
        for(int i=first; i<=last; i++){
            num[i-'A']=number;
        }
    }
}
