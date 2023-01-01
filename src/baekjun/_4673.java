package baekjun;

public class _4673 {
    public static void main(String[] args) {
        int n;
        int[] array = new int[10001];
        for(int i=1; i<=10000; i++){
            n = i;
            while(true){
                n = d(n);
                if(n>10000) break;
                array[n] = -1;
            }
        }
        for(int i=1; i<=10000;i++){
            if(array[i]!=-1) System.out.println(i);
        }
    }
    public static int d(int n){
        int result = n;
        while(n>0){
            result += n%10;
            n=(n-(n%10))/10;
        }
        return result;
    }
}
