package com.test.karate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {

        //"--spring.application.name='StudentApp'"
        //                ,"--server.port=8080"

        SpringApplication.run(MyApp.class, "--spring.application.name='ProviderApp'", "--server.port=8097");

    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
        Student stud = new Student("Kaushik", "Bagchi", 32,new Address("1123AD",67));
        return stud != null ? new ResponseEntity<>(stud, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

class Address{
    private String zipCode;
    private int huisnummer;

    public Address() {
    }

    public Address(String zipCode, int huisnummer) {
        this.zipCode = zipCode;
        this.huisnummer = huisnummer;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }
}

class Student {

    private String firstName;

    private String lastName;

    private int age;

    private Address address;

    public Student() {
        // TODO Auto-generated constructor stub
    }


    public Student(String firstName, String lastName, int age,Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}



