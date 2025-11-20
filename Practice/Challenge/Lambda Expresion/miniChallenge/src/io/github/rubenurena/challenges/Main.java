package io.github.rubenurena.challenges;
import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

//        //challenge #1 using Consumer: Split the sentence at each space " ".
        Consumer<String> consumer = (s)->{
            String[] splitIn = s.split(" ");
            Arrays.asList(splitIn).forEach(System.out::println);
        };
        consumer.accept("This is my example of lambda mini challenge #1");


//        //challenge #2 using Function: Take a string and print every second char.
        UnaryOperator<String> unaryOperator = (s)->{
            StringBuilder stringBuilder = new StringBuilder();
            for (int a = 0; a < s.length() ; a++){
                if (a%2== 1)stringBuilder.append(s.charAt(a));
            }
            return stringBuilder.toString();
        };
        System.out.println(unaryOperator.apply("This is my example of lambda mini challenge #2"));



//        //Challenge #3 make the preview challenge method:
        String string = "This is my example of lambda mini challenge #3";
        everySecondCharacter(unaryOperator,string);



//        //challenge #4 using Supplier: Create a Supplier lambdas that return "I love Java" then print it.
        Supplier<String> iLoveJava = ()-> "I Love Java!";
        System.out.println(iLoveJava.get());


//        //challenge #5 using Predicate: Return true when the age is greater than or equal to 18.
        Predicate<Integer> predicate =  (age)-> {
            return age >= 18;
        };

          //challenge #6 Create an Array of String, and add some names, use setAll methods to perform some Lambdas;
        // 1)-set the complete array to Uppercase.
        // 2)-Add a Random middle initial.
        // 3)-The last name is the first name spelled backwards.
        // Print using forEach.

        String[] names = {"Ruben","Juan","Ana", "Bob","Jen"};// 1)-set the complete array to Uppercase.
        Arrays.setAll(names, (u)-> names[u].toUpperCase());


        Arrays.setAll(names, (r)->{// 2)-Add a Random middle initial.
            Random random = new Random();
            char charRandom = (char)(random.nextInt(90-65+1)+65);
            return names[r]+" "+charRandom+".";
        });


        Arrays.setAll(names, ( l)->{// 3)-The last name is the first name spelled backwards.
            var split = names[l].split(" ")[0];
            var getName= split.split("");
            StringBuilder lastName = new StringBuilder();
            for (int ll = 1; ll <= split.length() ; ll++){
                lastName.append(getName[getName.length - ll]);
            }
            return names[l]+" "+lastName;
        }) ;


        ArrayList<String> list = new ArrayList<>(Arrays.asList(names));// 4)-Remove if the first name is equal to the last name.
        list.removeIf(  (s) ->{
            var split = s.split(" ");
            var getFirstName = split[0];
            var getLastName =  split[split.length-1];
            return getFirstName.equals(getLastName);
        });


        //Challenge #7
        //list.forEach( (aa)-> System.out.println(aa));//Print using forEach.
        // Create a list of UnaryOperator<String> containing multiple lambda expressions.
        // Lambda list should include at least one method reference.
        // Then create an array of names and apply all the operators inside the list to each element.
        // Implement this logic inside a separate method.
        String[] names2 = {"Juan","Ethan","Marcus","Maria","Anna","Hannah"};
        ArrayList<UnaryOperator<String>> operations = new ArrayList<>();
        operations.add( String::toUpperCase );
        operations.add( String::strip);
        operations.add( (s)->{
            Random random = new Random();
            char randomChar = (char) (random.nextInt(90-65+1)+65);
            return s+" "+randomChar+".";
        });//add a random second-name initial.
        operations.add( (s)->{
            String[] split = s.split(" ")[0].split("");
            StringBuilder reverseName = new StringBuilder();
            for (int a = 1; a <= split.length; a++){
                reverseName.append(split[split.length - a]);
            }
            return s+" "+reverseName.toString();
        });//The last name is the first name spelled backwards.
        operations.add( (s)->{
            if (s.charAt(0) == 'M'){
                s = s.substring(1);
                return "{M}"+s;
            }
            return s;
        });//If the name starts with M, then replace "M" with "{M}".
        var a =setOperations(operations, names);//create the method that implement all the lambdas
        System.out.println(Arrays.toString(a));














    }

    //Challenge #3:
    public static void everySecondCharacter(UnaryOperator<String> unaryOperator, String parameter){
        System.out.println(unaryOperator.apply(parameter));
    }

    //Challenge #7
    public static String[] setOperations(List<UnaryOperator<String>> operations, String[] names){
        for (var c : names){
            for (var ss : operations){
                c = c.transform(ss);
            }
        }
        return names;
    }



}

