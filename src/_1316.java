import java.util.Scanner;

public class _1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        boolean check;
        int[] alp = new int[26];
        for(int i=0; i<n; i++){
            check = true;
            String s = sc.next();
            for(int j=0; j<s.length(); j++){
                if(alp[s.charAt(j)-'a']==-1){
                    check=false;
                    break;
                }
                else alp[s.charAt(j)-'a']++;
                if(j<s.length()-1&&(s.charAt(j)!=s.charAt(j+1))) {
                    alp[s.charAt(j)-'a']=-1;
                }
            }
            if(check){
                count++;
            }
            for(int j=0; j<26; j++) alp[j]=0;
        }
        System.out.println(count);
        sc.close();
    }
}
