import java.util.Scanner;

public class _3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        int count = 0;
        boolean zero=false;
        for(int i=0; i<10; i++){
            array[i] = sc.nextInt()%42;
            if(array[i]==0) zero = true;
            for(int j=0; j<10; j++){
                if(array[i]==array[j]&&i!=j){
                    array[i]=0;
                    break;
                }
            }
        }
        for(int i=0; i<10; i++){
            if(array[i]!=0) count++;
        }
        System.out.println(count+=zero?1:0);
        sc.close();
    }
}
