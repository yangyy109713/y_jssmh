package aop;

public class MathCalculator {

    public int div(int i, int j){
        System.out.println("目标方法...div...");
        return i / j;
    }
}
