package com.login.test.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Demo27 {

	public static void main(String[] args) {

		CglibProxy proxy = new CglibProxy();
		// 通过生成子类的方式创建代理类
		SayHello proxyImp = (SayHello) proxy.getProxy(SayHello.class);
		proxyImp.say();
		proxyImp.said();
		
		

	}

}

class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		// 设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		// 通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	// 实现MethodInterceptor接口方法
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		System.out.println("前置代理");
		// 通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("后置代理");
		return result;
	}
}

class SayHello {
	public void say() {
		System.out.println("hello everyone");
	}
	
	public void said(){
		System.out.println("hello world");
	}
}

class JDKProxy implements InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		return null;
	}
	
}



class MyInvocationHandler implements InvocationHandler {  
    private Object target;  
  
    MyInvocationHandler() {  
        super();  
    }  
  
    MyInvocationHandler(Object target) {  
        super();  
        this.target = target;  
    }  
  
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {  
        if("getName".equals(method.getName())){  
            System.out.println("++++++before " + method.getName() + "++++++");  
            Object result = method.invoke(target, args);  
            System.out.println("++++++after " + method.getName() + "++++++");  
            return result;  
        }else{  
            Object result = method.invoke(target, args);  
            return result;  
        }  
  
    }  
}  