package designPrincinple;

/**
 * 设计模式-依赖倒置原则 示例说明
 * 高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象
 * 核心思想是：要面向接口编程，不要面向实现编程
 */
public class DIPtest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("顾客购买一下商品：");
        customer.shopping(new ShaoguanShop());
        customer.shopping(new WuyuanShop());
    }
}

//商店
interface Shop {
    String sell();
}

//韶关商店
class ShaoguanShop implements Shop {
    public String sell() {
        return "韶关土特产：香菇、木耳...";
    }
}

//婺源商店
class WuyuanShop implements Shop {
    public String sell() {
        return "婺源土特产：绿茶、酒精鱼...";
    }
}

class Customer {
    public void shopping(Shop shop) {
        //购物
        System.out.println(shop.sell());
    }
}