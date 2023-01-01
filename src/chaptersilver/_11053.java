package chaptersilver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();

        for(int i=0; i<n; i++){
            array.add(sc.nextInt());
        }

        System.out.println(check(array));
    }

    private static int check(List<Integer> array) {
        int max=0, num;
        for(int i=0; i<array.size(); i++){
            num = checkLength(array,i);
            if(max<num)
                max=num;
        }
        return max;
    }

    private static int checkLength(List<Integer> array, int index){
        int count=1;
        int number= array.get(index);
        for(int i=index+1; i<array.size(); i++){
            if(number < array.get(i)){
                count++;
                number = array.get(i);
            }
        }
        return count;
    }
}
