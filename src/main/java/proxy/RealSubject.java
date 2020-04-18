package proxy;

/**
 * 真实主题
 */
public class RealSubject implements AbstractSubject {
    /**
     * 方法
     */
    @Override
    public void dosomething() {
        System.out.println("do something");
    }
}
