package ro.sda.spring.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class TestService implements InitializingBean, DisposableBean {

    @PostConstruct
    void init() {
        System.out.println("Init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Same as init");
    }

    @PreDestroy
    void preDestroy() {
        System.out.println("Destroying bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Same as preDestroy");
    }
}
