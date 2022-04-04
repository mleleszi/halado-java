package com.example.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchApplication implements CommandLineRunner {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    JobLauncher jobLauncher;

    @Qualifier("csvToConsole")
    @Autowired
    Step csvToConsole;

    @Qualifier("csvToXml")
    @Autowired
    Step csvToXml;

    @Qualifier("xmlToConsole")
    @Autowired
    Step xmlToConsole;

    @Qualifier("xmlToCsv")
    @Autowired
    Step xmlToCsv;


    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Job job = jobBuilderFactory
                .get("job")
                .start(xmlToCsv)
                .next(csvToConsole)
                .build();

        jobLauncher.run(job, new JobParameters());
    }
}
