package org.example.Annotation_Problems.AdvanceProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface CacheResult {}

// Step 2: Create a Service Class with a Cached Method
class ExpensiveService {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }
        System.out.println("Computing square for: " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

// Step 3: Implement Caching Logic with Reflection
class CacheHandler {
    private static final Map<String, Map<Object, Object>> globalCache = new HashMap<>();

    public static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, int.class);

            if (method.isAnnotationPresent(CacheResult.class)) {
                globalCache.putIfAbsent(methodName, new HashMap<>());
                Map<Object, Object> methodCache = globalCache.get(methodName);

                if (methodCache.containsKey(args[0])) {
                    System.out.println("Returning cached result for: " + args[0]);
                    return methodCache.get(args[0]);
                }

                Object result = method.invoke(obj, args);
                methodCache.put(args[0], result);
                return result;
            } else {
                return method.invoke(obj, args);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error invoking cached method", e);
        }
    }
}

// Step 4: Test the Caching System
public class Problem3 {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        System.out.println(CacheHandler.invokeWithCache(service, "computeSquare", 5)); // Computes & stores
        System.out.println(CacheHandler.invokeWithCache(service, "computeSquare", 5)); // Retrieves from cache
        System.out.println(CacheHandler.invokeWithCache(service, "computeSquare", 10)); // Computes & stores
        System.out.println(CacheHandler.invokeWithCache(service, "computeSquare", 10)); // Retrieves from cache
    }
}
