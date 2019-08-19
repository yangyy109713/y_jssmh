package simpleFactory;

/**
 * 工厂类是"FruitFactory"。
 * FruitFactory是水果工厂，水果工厂会生成水果。
 */
public class FruitFactory {
    public static Fruit newInstance(String name) throws Exception {
        // 如果name等于"apple"(忽略大小写)，则返回苹果
        if ("apple".equalsIgnoreCase(name)) {
            return new Apple();
        }
        // 如果name等于"grape"(忽略大小写)，则返回葡萄
        else if ("grape".equalsIgnoreCase(name)) {
            return new Grape();
        }
        // 如果name等于"strawberry"(忽略大小写)，则返回草莓
        else if ("strawberry".equalsIgnoreCase(name)) {
            return new Strawberry();
        }
        throw new Exception("Bad fruit request!");
    }
}
