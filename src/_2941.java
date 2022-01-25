import java.util.Scanner;

public class _2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.next();
        int cout = 0;
        String sub2, sub3;
        for(int i=0; i<s.length(); i++){
            sub2 = (i<s.length()-1)?s.substring(i, i+2):"";
            sub3 = (i<s.length()-2)?s.substring(i, i+3):"";
            if(sub2.equals("c=")||sub2.equals("c-")||sub2.equals("d-")||sub2.equals("lj")||sub2.equals("nj")||sub2.equals("s=")||sub2.equals("z=")){
                cout++;
                i++;
            }
            else if(sub3.equals("dz=")){
                cout++;
                i+=2;
            } else cout++;
        }
        System.out.println(cout);
        sc.close();
    }
}
