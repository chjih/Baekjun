package DFS_BFS;

public class test {
    public static void main(String[] args) {
        A a = new B();

        a.print();
    }
}

class A{
    int a;
    public void print(){
        System.out.println("a");
    }
}

class B extends A{
    @Override
    public void print(){
        System.out.println("b");
    }
}
