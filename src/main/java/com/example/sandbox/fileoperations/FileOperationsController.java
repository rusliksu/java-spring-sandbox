package com.example.sandbox.fileoperations;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/file-operations")
public class FileOperationsController {

    @Value("${file.operations.test.path:test_file.txt}")
    private String testFilePath;

    @PostConstruct
    public void init() throws IOException {
        Path path = Paths.get(testFilePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.println("Создан тестовый файл: " + testFilePath);
        }
    }

    @GetMapping("/read-buffered")
    public String readBuffered() {
        FileOperationsDemo.readFileBufferedReader(testFilePath);
        return "Файл прочитан с использованием BufferedReader. Проверьте консоль.";
    }

    @GetMapping("/read-scanner")
    public String readScanner() {
        FileOperationsDemo.readFileScanner(testFilePath);
        return "Файл прочитан с использованием Scanner. Проверьте консоль.";
    }

    @GetMapping("/read-nio")
    public String readNIO() {
        FileOperationsDemo.readFileNIO(testFilePath);
        return "Файл прочитан с использованием NIO. Проверьте консоль.";
    }

    @PostMapping("/write")
    public String write(@RequestBody List<String> content) {
        FileOperationsDemo.writeFile(testFilePath, content);
        return "Файл записан. Проверьте содержимое файла.";
    }

    @PostMapping("/append")
    public String append(@RequestBody String content) {
        FileOperationsDemo.appendToFile(testFilePath, content);
        return "Содержимое добавлено в конец файла.";
    }

    @GetMapping("/count-words")
    public String countWords() {
        return "Количество слов в файле: " + FileOperationsDemo.countWords(testFilePath );
    }
}
