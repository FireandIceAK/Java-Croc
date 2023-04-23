package ru.croc.task14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class InputFile {
    public static Map<Integer, String> films;
    public static List<Set<Integer>> listOfViews;
    private Path pathFilms;
    private Path pathViews;

    private void InputFilms() throws IOException {
        List<String> allFilms = Files.readAllLines(pathFilms);
        for(String film: allFilms) {
            Integer number = Integer.parseInt(film.substring(0, film.indexOf(',')));
            String nameFilm = film.substring(film.indexOf(',') + 1);
            films.put(number, nameFilm);
        }
    }
    private void InputViews() throws IOException {
        List<String> allViews = Files.readAllLines(pathViews);
        for(String view: allViews) {
            Set<Integer> views = new HashSet<>();
            String[] numbers = view.split(",");
            for(String number:numbers) {
                views.add(Integer.parseInt(number));
            }
            listOfViews.add(views);
        }
    }
    public InputFile(String pathFilms, String pathViews) throws IOException {
        films = new HashMap<>();
        listOfViews = new ArrayList<>();
        this.pathFilms = Paths.get(pathFilms);
        this.pathViews = Paths.get(pathViews);
        InputFilms();
        InputViews();
    }

}
