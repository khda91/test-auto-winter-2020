package ru.levelup.qa.at.java.exceptons;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionExample {

    private String fileName;

    public ExceptionExample(String fileName) {
        this.fileName = fileName;
    }

    void write() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < 1000; i++) {
                out.println("Something");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    void writeWithResources() {
        try (PrintWriter out = new PrintWriter(new FileWriter(this.fileName))) {
            for (int i = 0; i < 1000; i++) {
                out.println("Something");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Задайте имя файла в качестве аргумента к программе");
        }
        ExceptionExample ee = new ExceptionExample(args[0]);
        ee.write();
        ee.writeWithResources();
    }

}
