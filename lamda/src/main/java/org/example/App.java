package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String, Integer> nameMap = new HashMap<>();
        App app = new App();
        Integer value = nameMap.computeIfAbsent("John", App::length);
        Integer value2 = nameMap.computeIfAbsent("John", name -> name.length());
        Integer value3 = nameMap.computeIfAbsent("John", name -> {
            return app.v(name);
        });
        app.printResult(a -> 2 * a);
    }

    public static int length(String s) {
        return s.length();
    }

    public int v(String s) {
        return s.indexOf("d");
    }

    private void printResult(Function<Integer, Integer> fv) {
        int result = fv.apply(5);
        System.out.println(result);
    }


    private void printResult(Supplier<Integer> fv) {
        Integer result = fv.get();
        System.out.println(result);
    }

    private void dataIn(Consumer<Integer> fv) {
        fv.accept(8);
    }

    private void kiirHaOk(Predicate<String> pred, String s) {
        if(pred.test(s)) {
            System.out.println(s);
        }
    }
}
