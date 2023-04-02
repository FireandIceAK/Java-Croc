package ru.croc.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String removeJavaComments(String source) {
        StringBuilder stringNew = new StringBuilder();
        //Создаём шаблон
        Pattern pattern = Pattern.compile("(/\\*([\\S\\s]+?)\\*/)|(//.*)");
        Matcher matcher = pattern.matcher(source);
        //Если находятся совпадения с шаблоном, они удаляются
        while (matcher.find()) {
            matcher.appendReplacement(stringNew, "");
        }
        //Выводим нашу новую строку
        return String.valueOf(stringNew);
    }

    public static void main(String[] args) {
        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "\n" +
                "    /* \n" +
                "    * main method \n" +
                "    */\n" +
                "    public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "        // this line prints my first greeting to the screen\n" +
                "        System.out.println(\"Hi!\"); // :)\n" +
                "    }\n" +
                "} // the end\n" +
                "// to be continued...\n";
        //С помощью созданного метода удаляем комментарии и выводим обновлённую строку
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }
}
