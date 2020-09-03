package lesson3;

import java.util.*;

public class Words {
    public static void main(String[] args){
        List<String> fruit = Arrays.asList("яблоко", "банан", "киви", "банан",
                "дыня", "арбуз", "манго", "арбуз", "персик", "банан");

        Set<String> unique = new HashSet<>(fruit);
        System.out.println("Список уникальных слов:");
        System.out.println(unique.toString());
        System.out.println("Частота, с которой встречаются слова:");
        for(String key : unique){
            System.out.println(key + " : " + Collections.frequency(fruit,key));
        }

    }
}
