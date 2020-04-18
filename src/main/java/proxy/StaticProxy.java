package proxy;

/**
 * 静态代理
 */
public class StaticProxy implements AbstractSubject {
    private AbstractSubject target;

    public StaticProxy(AbstractSubject target) {
        this.target = target;
    }

    /**
     * 方法
     */
    @Override
    public void dosomething() {
        System.out.println("current time  ="+System.currentTimeMillis());
        target.dosomething();
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        StaticProxy proxy = new StaticProxy(realSubject);
        proxy.dosomething();
    }
}
