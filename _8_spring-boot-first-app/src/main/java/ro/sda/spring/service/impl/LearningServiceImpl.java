package ro.sda.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ro.sda.spring.service.LearningService;

@Slf4j
@Service
@Profile("learning")
public class LearningServiceImpl implements LearningService {

    public LearningServiceImpl() {
        log.info("LearningServiceImpl constructor called!");
    }

    @Override
    public String getStaticContent() {
        return "learning.html";
    }
}
