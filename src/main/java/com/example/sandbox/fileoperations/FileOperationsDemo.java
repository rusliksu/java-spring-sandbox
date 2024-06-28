package com.example.sandbox.fileoperations;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileOperationsDemo {

    public static void readFileBufferedReader(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            System.out.println("Файл не существует или недоступен для чтения");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void readFileScanner(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            System.out.println("Файл не существует или недоступен для чтения");
            return;
        }

        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void readFileNIO(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            System.out.println("Файл не существует или недоступен для чтения");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void writeFile(String filePath, List<String> content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    public static void appendToFile(String filePath, String content) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8, true))) {
            writer.write(content);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении в файл: " + e.getMessage());
        }
    }

    public static long countWords(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path) || !Files.isReadable(path)) {
            System.out.println("Файл не существует или недоступен для чтения");
            return 0;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .count();
        } catch (IOException e) {
            System.out.println("Ошибка при подсчете слов: " + e.getMessage());
            return 0;
        }
    }
}
