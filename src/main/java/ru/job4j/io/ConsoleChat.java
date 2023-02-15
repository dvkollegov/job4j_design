package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> listAnswers = new ArrayList<>();
    private final List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        this.readPhrases();
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();
        log.add(question);
        while (!question.equals(OUT)) {
            if (question.equals(STOP)) {
                while (!question.equals(CONTINUE)) {
                    question = scanner.nextLine();
                    log.add(question);
                }
            }
            String answers = this.randomAnswer();
            System.out.println(answers);
            log.add(answers);
            question = scanner.nextLine();
            log.add(question);
        }
        this.saveLog(log);
    }

    private List<String> readPhrases() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            listAnswers = in.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listAnswers;
    }

    private String randomAnswer() {
        return listAnswers.get((int) (Math.random() * listAnswers.size()));
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            for (String s : log) {
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/log_console_chat.txt", "data/answer_console_chat.txt");
        cc.run();
    }
}
