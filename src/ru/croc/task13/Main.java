package ru.croc.task13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Filter filter = new Filter();
        List<String> comments = new ArrayList<>(Arrays.asList("HI", "goodword", "hello", "hi man"));
        System.out.println("comments: " + comments);
        Set<String> badWords = Set.of("go", "hi");
        System.out.println("badWords: " + badWords);
        filter.filterComments(comments, badWords);
        System.out.println("result: " + comments);
    }
}
