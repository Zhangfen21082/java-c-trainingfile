public class OuterClass {
    public int outer_a = 1;
    public int outer_b = 2;
    public static int outer_static = 3;

    static class InnerClass{
        public int inner_a = 4;
        public int inner_b = 5;
        public static int inner_static;

        public void test(){
            OuterClass out = new OuterClass();
            System.out.println(out.outer_a);
            System.out.println(out.outer_b);
        }
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.test();
    }
}

