package com.seriouscompanyname.serverhospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication(scanBasePackages = "com.seriouscompanyname.serverhospital")
public class ServerHospitalApplication {

    public static void main(String[] args) {
        Logger.getAnonymousLogger().log(Level.FINE, "Working");
        SpringApplication.run(ServerHospitalApplication.class, args);
    }

}
