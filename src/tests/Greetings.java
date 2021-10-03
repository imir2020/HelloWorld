package tests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
реализуйте метод с сигнатурой void printAnnotation(),
 который печатает на консоль для класса Greetings название метода + пробел + значение text
  аннотации AnnotationTest, если таковое определено.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AnnotationTest {
    String text() default "Say Hello all time";
}

public class Greetings {
    @AnnotationTest
    void hello() {
    }
    @AnnotationTest
    void goodDay() {
    }
    @AnnotationTest
    void goodnight() {
    }
    @AnnotationTest
    void hi() {
    }

    //@AnnotationTest(text = "Say FUCK YOU all time")
    void printAnnotation() {
        Method[] met = Greetings.class.getDeclaredMethods();
        for (Method n : met) {
            if(n.isAnnotationPresent(AnnotationTest.class)){
                String an = n.getName();
                AnnotationTest ant = n.getAnnotation(AnnotationTest.class);
                String annotation = ant.text();
                System.out.println(an + " " + annotation);
            }
        }
    }

    public static void main(String[] args) {
        Greetings g = new Greetings();
        g.printAnnotation();
    }
}
