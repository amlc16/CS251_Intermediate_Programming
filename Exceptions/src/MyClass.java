public class MyClass {
    private int x = 10;

    public static void main(String[] args) {
        x++;
        System.out.println(x);
    }
    public static void bar(int n) throws Exception{
        if(5 > n) {
            System.out.println("Small");
        } else {
            throw new Exception("Big!");
        }
    }

}
