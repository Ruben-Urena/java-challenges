package io.github.rubenurena.challenges;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        //challenge #1 using Consumer: Split the sentence at each space " ".
        Consumer<String> consumer = (s)->{
            String[] splitIn = s.split(" ");
            Arrays.asList(splitIn).forEach( (ite)-> System.out.println(ite));
        };
        consumer.accept("This is my example of lambda mini challenge #1");


        //challenge #2 using Function: Take a string and print every second char.
        UnaryOperator<String> unaryOperator = (s)->{
            StringBuilder stringBuilder = new StringBuilder();
            for (int a = 0; a < s.length() ; a++){
                if (a%2== 1)stringBuilder.append(s.charAt(a));
            }
            return stringBuilder.toString();
        };
        System.out.println(unaryOperator.apply("This is my example of lambda mini challenge #2"));



        //Challenge #3 make the preview challenge method:
        String string = "This is my example of lambda mini challenge #3";
        everySecondCharacter(unaryOperator,string);



        //challenge #4 using Supplier: Create a Supplier lambdas that return "I love Java" then print it.
        Supplier<String> iLoveJava = ()-> "I Love Java!";
        System.out.println(iLoveJava.get());


        //challenge #5 using Predicate: Return true when the age is greater than or equal to 18.
        Predicate<Integer> predicate =  (age)-> {
            return age >= 18;
        };

    }

    //Challenge #3:
    public static void everySecondCharacter(UnaryOperator<String> unaryOperator, String parameter){
        System.out.println(unaryOperator.apply(parameter));
    }


}

