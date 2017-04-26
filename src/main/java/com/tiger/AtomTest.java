package com.tiger;

import com.tiger.service.impl.AtomTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AtomTest implements CommandLineRunner {

    @Autowired
    AtomTransactionServiceImpl atomTransactionService;

    public static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(AtomTest.class, args);
        SpringApplication.exit(ctx);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            atomTransactionService.insertTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}