package com.test.karate;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

@RunWith(Karate.class)
@CucumberOptions(features = "classpath:karatefeature")
public class KarateTest {

    @BeforeClass
    public static void startApp(){

        SpringApplication.run(MyApp.class, "--spring.application.name='ProviderApp'", "--server.port=8097");

    }
}
