package com.example.sandbox.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exceptions")
public class ExceptionController {

    private final ExceptionExamples exceptionExamples;

    @Autowired
    public ExceptionController(ExceptionExamples exceptionExamples) {
        this.exceptionExamples = exceptionExamples;
    }

    @RequestMapping("/checked")
    public void demonstrateChecked() throws Exception {
        exceptionExamples.demonstrateCheckedException();
    }

    @RequestMapping("/unchecked")
    public void demonstrateUnchecked() {
        exceptionExamples.demonstrateUncheckedException();
    }

    @RequestMapping("/custom")
    public void demonstrateCustom() throws CustomException {
        exceptionExamples.demonstrateCustomException();
    }

    @RequestMapping("/try-catch")
    public void demonstrateTryCatch() {
        exceptionExamples.demonstrateTryCatchFinally();
    }

    @RequestMapping("/multiple-catch")
    public void demonstrateMultipleCatch() {
        exceptionExamples.demonstrateMultipleCatch();
    }
}
