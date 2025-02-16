package org.example.Reflection_Problems.Advance_Problems;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an Interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Implement the Interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Dynamic Proxy Handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method call
        System.out.println("Method Called: " + method.getName());

        // Execute the actual method on the target object
        return method.invoke(target, args);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        // Step 4: Create a Proxy Instance
        Greeting originalGreeting = new GreetingImpl();

        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(originalGreeting)
        );

        // Step 5: Use the Proxy Object
        proxyGreeting.sayHello("Abhay");
    }
}
