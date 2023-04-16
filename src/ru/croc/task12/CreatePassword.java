package ru.croc.task12;

public class CreatePassword {

    public static volatile String password;
    public static volatile String hex;

    public static void main(String[] args) {
        int threadsCount = Integer.parseInt(args[0]);
        hex = args[1];
        Thread[] threads = new Thread[threadsCount];
        for (int i = 1; i <= threadsCount; ++i) {
            threads[i - 1] = new Thread(new Run(i, threadsCount, 7));
            threads[i - 1].start();
        }
        try {
            for (int i = 0; i < threadsCount; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Password: " + password);
    }
}