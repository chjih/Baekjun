import java.util.Arrays;
import java.util.Scanner;

class Member{
    String name;
    int age;
    public Member(int age, String name){
        this.age = age;
        this.name = name;
    }
    public void getAgeName(){
        System.out.println(age+" "+name);
    }
}

public class _10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Member[] ar = new Member[n];
        for(int i=0; i<n; i++){
            ar[i] = new Member(sc.nextInt(), sc.next());
        }
        Arrays.sort(ar, ((o1, o2) -> {
            //따로 변경안해도 0 리턴 시 자동적으로 원래 순서대로 정렬됨
            if(o1.age==o2.age) return 0;
            else return o1.age-o2.age;
        }));
        for(int i=0; i<n; i++) ar[i].getAgeName();
        sc.close();
    }
}
