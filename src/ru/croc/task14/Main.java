package ru.croc.task14;

import java.io.IOException;
import java.util.*;

public class Main {
    public static InputFile inputFile;

    static {
        try {
            inputFile = new InputFile("C:/Users/Tolya/IdeaProjects/Java/src/ru/croc/task14/film.txt",
                    "C:/Users/Tolya/IdeaProjects/Java/src/ru/croc/task14/views.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Алгоритм выбирает из списка просмотров те, которые содержат фильмы, отвечающие определенным критериям. Затем из них выбираются только те, которые пользователь еще не смотрел.
    public static Set<Integer> crossings(Set<Integer> userFilms) {
        Set<Integer> crossing = new HashSet<>();
        for (Set<Integer> views : InputFile.listOfViews) {
            Set<Integer> result = new HashSet<>();
            result.addAll(userFilms);
            result.retainAll(views);
            if (result.size() >= (userFilms.size() - 1) / 2 + 1) {
                Set<Integer> removes = new HashSet<>();
                removes.addAll(views);
                removes.removeAll(userFilms);
                crossing.addAll(removes);
            }
        }
        return crossing;
    }

    // Выбирает одну рекомендацию из всех
    public static Integer Recommendation(Set<Integer> allRecommendation) {
        int maxIndex = 0;
        Integer maxContain = null;
        for (Integer recommendation : allRecommendation) {
            int temp = 0;
            for (Set<Integer> views : InputFile.listOfViews) {
                if (views.contains(recommendation)) {
                    temp++;
                }
            }
            if (temp > maxIndex) {
                maxIndex = temp;
                maxContain = recommendation;
            }
        }
        return maxContain;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] films = line.split(",");
        Set<Integer> userFilms = new HashSet<>();
        for (String film : films) {
            userFilms.add(Integer.parseInt(film));
        }
        Set<Integer> allRecommendation = crossings(userFilms);
        Integer recommendation = Recommendation(allRecommendation);
        if (recommendation != null) {
            System.out.println(InputFile.films.get(recommendation));
        } else {
            System.out.println("Not recommendation");
        }
    }
}
