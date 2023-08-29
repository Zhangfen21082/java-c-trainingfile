
public class TestDemo {
    public static void main(String[] args) {
        //以数组形式返回枚举类型的所有成员，然后遍历输出枚举成员和其序号
        Color[] enums = Color.values();
        for(int i = 0; i < enums.length; i++){
            System.out.println(enums[i] + "序号" + enums[i].ordinal());
        }
        //通过返回枚举实例
        System.out.println("======================================");
        Color green = Color.valueOf("GREEN");
        System.out.println(green);

        //比较枚举成员顺序大小（序号大小）
        System.out.println("======================================");
        Color red = Color.valueOf("RED");
        Color black = Color.valueOf("BLACK");
        System.out.println(red.compareTo(black) < 0 ? "RED<BLACK" : "RED>BLACK");
    }
}
