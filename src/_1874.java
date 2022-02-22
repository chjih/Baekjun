import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder write=new StringBuilder();
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i]=sc.nextInt();
        }
        //정렬
        int[] sort = array.clone();
        Arrays.sort(sort);
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int i = 0;
        while(num+stack.size()<sort.length){
            //해당 값까지 스택에 push
            write.append("+"+"\n");
            stack.add(sort[i++]);
            //가능한 값까지 스택에서 pop
            while (num<sort.length && stack.size()>0 && array[num] == stack.peek()){
                write.append("-"+"\n");
                num++;
                stack.pop();
            }
        }
        if(num==sort.length){
            System.out.println(write.toString());
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }
}
