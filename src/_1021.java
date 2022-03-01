import java.util.Scanner;

public class _1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int n = sc.nextInt();
        int[] ar = new int[length+1];
        int re, cu, count=0;
        re = sc.nextInt();
        ar[re]=-1;
        count+=Math.min(re-1, length+1-re);
        re=(re+1==length+1)?1:re+1;
        for(int i=1; i<n; i++){
            cu = sc.nextInt();
            int gap1=0, gap2=0, r = re;
            while(r!=cu){
                r++;
                if(r==length+1) r=1;
                if(ar[r]!=-1){
                    gap1++;
                }
            }
            while(re!=cu){
                re--;
                if(re==0) re=length;
                if(ar[re]!=-1){
                    gap2++;
                }
            }
            ar[cu]=-1;
            //poll으로 뺀 다음 인덱스로 옮겨줌(마지막 원소가 아닐때)
            while(i+1!=n){
                if(++cu==length+1) cu=1;
                if(ar[cu]!=-1){
                    re=cu;
                    break;
                }
            }
            count+=Math.min(gap1, gap2);
        }
        System.out.println(count);
        sc.close();
    }
}
