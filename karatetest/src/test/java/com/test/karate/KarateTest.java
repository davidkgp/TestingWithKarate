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

        SpringApplication.run(MyApp.class,
                "--security.require-ssl=true",
                "--server.ssl.key-store-type=JKS",
                "--server.ssl.key-store=classpath:jks/mykey.jks",
                "--server.ssl.key-store-password=test123",
                "--spring.application.name='ProviderApp'",
                "--server.port=8097");

    }
}
