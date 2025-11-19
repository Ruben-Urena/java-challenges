package io.github.rubenurena.challenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        // Create a list of UnaryOperator<String> containing multiple lambda expressions.
        // Each lambda should include at least one method reference.
        // Then create an array of names and apply all the operators inside the list to each element.
        // Implement this logic inside a separate method.
        String[] names = {"Juan","Ethan","Marcus","Maria","Anna","Hannah"};
        ArrayList<UnaryOperator<String>> operations = new ArrayList<>();
        operations.add( String::toUpperCase );
        operations.add( String::strip);
        operations.add( (s)->{
            Random random = new Random();
            char randomChar = (char) (random.nextInt(90-65+1)+65);
            return s+" "+randomChar;
        });
        operations.add( (s)->{
            String[] split = s.split(" ")[0].split("");
            StringBuilder reverseName = new StringBuilder();
            for (int a = 1; a <= split.length; a++){
                reverseName.append(split[split.length - a]);
            }
            return s+" "+reverseName.toString();
        });
        operations.add( (s)->{
            if (s.charAt(0) == 'M'){
                s = s.substring(1);
                return "{M}"+s;
            }
            return s;
        });
        var a =setOperations(operations, names);
        System.out.println(Arrays.toString(a));









    }
    public static String[] setOperations(List<UnaryOperator<String>> operations, String[] names){
        for (var c : names){
            for (var ss : operations){
                c = c.transform(ss);
            }
        }
        return names;
    }
}