package simpleFactory;

/**
 * Product类是"Fruit"。
 * Fruit代表水果，它是抽象类，包含水果的基本特征：生长，种植，收获。
 */
public abstract class Fruit {
    abstract void grow();

    abstract void harvest();

    abstract void plant();
}
