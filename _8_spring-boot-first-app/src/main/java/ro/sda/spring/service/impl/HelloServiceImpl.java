package ro.sda.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.sda.spring.service.LearningService;

@Slf4j
@Service
@Profile("hello")
public class HelloServiceImpl implements LearningService {

    public HelloServiceImpl() {
        log.info("HelloServiceImpl constructor called!");
    }

    @Override
    public String getStaticContent() {
        return "hello.html";
    }
}
