package io.brau.aws_project01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/dog/{name}")
    public ResponseEntity<?> dogTest(@PathVariable String name) {
        logger.info("Test controller - name: {}", name);

        return ResponseEntity.ok("Name: " + name);
    }

    @GetMapping("/dog/color")
    public ResponseEntity<?> dogColorTest() {
        logger.info("Test controller - Always Black");

        return ResponseEntity.ok("Always Black");
    }

    @GetMapping("/cat/{name}")
    public ResponseEntity<?> catTest(@PathVariable String name) {
        logger.info("Test controller - Cat Name: {}", name);

        return ResponseEntity.ok("Name: " + name);
    }
}
