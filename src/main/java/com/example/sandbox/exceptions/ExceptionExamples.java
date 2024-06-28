package com.example.sandbox.exceptions;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ExceptionExamples {

    public void demonstrateCheckedException() throws IOException {
        throw new FileNotFoundException("Демонстрация checked exception");
    }

    public void demonstrateUncheckedException() {
        throw new RuntimeException("Демонстрация unchecked exception");
    }

    public void demonstrateCustomException() throws CustomException {
        throw new CustomException("Демонстрация custom exception");
    }

    public void demonstrateTryCatchFinally() {
        try {
            System.out.println("Попытка выполнения кода");
            throw new RuntimeException("Ошибка в блоке try");
        } catch (RuntimeException e) {
            System.out.println("Перехват исключения: " + e.getMessage());
        } finally {
            System.out.println("Блок finally всегда выполняется");
        }
    }

    public void demonstrateMultipleCatch() {
        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Перехвачено общее Exception: " + e.getMessage());
        }
    }
}
