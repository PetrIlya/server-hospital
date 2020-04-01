package com.seriouscompanyname.serverhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerHospitalApplication {
    static {
        System.out.println("No errors occured 0");
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerHospitalApplication.class, args);
    }

}
