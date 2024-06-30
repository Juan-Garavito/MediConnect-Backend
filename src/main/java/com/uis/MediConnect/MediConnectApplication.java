package com.uis.MediConnect;

import com.uis.MediConnect.Config.AESEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MediConnectApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(MediConnectApplication.class, args);
	}

}
