package ro.sda.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.spring.service.LearningService;

@Controller
@Slf4j
public class LearningController {
    private LearningService learningService;

    public LearningController(LearningService learningService) {
        this.learningService = learningService;
    }

    @GetMapping("/hello")
    public String hello() {
        String response = learningService.getStaticContent();
        log.info("A requested was made!");
        return response;
    }
}
