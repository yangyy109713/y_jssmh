package simpleFactory;

public class FruitFactoryTest {
    public static void main(String[] args) {
        try {
            Fruit apple = FruitFactory.newInstance("Apple");
            apple.plant();
            apple.grow();
            apple.harvest();

            Fruit grape = FruitFactory.newInstance("Grape");
            grape.plant();
            grape.grow();
            grape.harvest();

            Fruit strawberry = FruitFactory.newInstance("strawberry");
            strawberry.plant();
            strawberry.grow();
            strawberry.harvest();

            Fruit error = FruitFactory.newInstance("error");
            error.plant();
            error.grow();
            error.harvest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * 结果说明：
 * FruitFactoryTest 成功创建了Apple, Grape, Strawberry这3个水果对象，并调用了它们的方法；
 * 然后创建error时，由于不存在error对应的水果，因此抛出异常。
 * (01) Fruit，是抽象产品。Fruit中声明了grow(), harvest(), plant()这3个函数接口，它们是水果共用拥有的行为。
 * (02) Apple, Grape和Strawberry这三个类是具体产品。
 * Apple -- 实现Fruit的函数接口，并且Apple中有私有成员age和私有方法log。
 * Grape -- 仅仅只实现Fruit的函数接口。
 * Strawberry -- 实现Fruit的函数接口，并且Strawberry中有私有方法log
 * (03) FruitFactory，是工厂类。通过它的newInstance()方法，我们可以获取相应的Fruit对象。
 * 若要获取的水果不存在，则抛出BadFruitException异常。BadFruitException是Exception的子类。
 */