package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("current time ="+System.currentTimeMillis());
        return method.invoke(target,args);
    }

    public static void main(String[] args) {
        // 1. 创建被代理的对象，RealSubject
        RealSubject realSubject = new RealSubject();
        // 2. 获取对应的 ClassLoader
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        // 3. 获取所有接口的Class，这里的RealSubject只实现了一个接口AbstractSubject，
        Class[] interfaces = realSubject.getClass().getInterfaces();
        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //     这里创建的是一个自定义的日志处理器，须传入实际的执行对象 realSubject
        InvocationHandler dynamicProxy = new DynamicProxy(realSubject);
        /*
		   5.根据上面提供的信息，创建代理对象 在这个过程中，
               a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
               b.然后根据相应的字节码转换成对应的class，
               c.然后调用newInstance()创建代理实例
		 */
        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(classLoader, interfaces, dynamicProxy);
        // 调用代理的方法
        proxy.dosomething();


    }
}
