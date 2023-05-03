package ru.croc.finalProject.src;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        Translator translator;
        Menu menu = new Menu();
        int solution;
        do {
            menu.show();

            solution = scan.nextInt();

            switch (solution) {

                case 1:
                    System.out.println("Enter english word:");
                    String english = new Scanner(System.in).nextLine();
                    System.out.println("Enter translate:");
                    String russia = new Scanner(System.in).nextLine();
                    dictionary.addWord(english, russia);
                    break;
                case 2:
                    System.out.println("Enter english sentence:");
                    String englishSentence = new Scanner(System.in).nextLine();
                    translator = new Translator(dictionary);
                    translator.TranslateEnglishToRussia(englishSentence);
                    break;
                case 3:
                    System.out.println("Enter russia sentence:");
                    String russiaSentence = new Scanner(System.in).nextLine();
                    translator = new Translator(dictionary);
                    translator.TranslateRussiaToEnglish(russiaSentence);
                    break;
                case 4:
                    System.out
                            .println("Enter path to save dictionary(EXAMPLE d:\\java\\dictionary.txt):");
                    String path = new Scanner(System.in).nextLine();
                    dictionary.save(path);
                    break;
                case 5:
                    System.out
                            .println("Enter path to load dictionary(EXAMPLE d:\\java\\dictionary.txt):");
                    path = new Scanner(System.in).nextLine();
                    path.replace("\\", "\\\\");
                    dictionary.load(path);
                    break;
                case 6:
                    if (dictionary.getDictionary().size() == 0)
                        System.out
                                .println("Your dictionary is empty! Please add word or load dictionary from file.");
                    else System.out.println(dictionary.getDictionary());
                    break;
                default:
                    if (solution != 0)
                        System.out.println("Invalid choose!");
                    break;
            }
        } while (solution != 0);
    }
}