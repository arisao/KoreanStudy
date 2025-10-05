package com.koreanstudy;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class KoreanStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KoreanStudyApplication.class, args);
		System.out.println("JASYPT_ENCRYPTOR_PASSWORD=" + System.getenv("JASYPT_ENCRYPTOR_PASSWORD"));

	}

}
