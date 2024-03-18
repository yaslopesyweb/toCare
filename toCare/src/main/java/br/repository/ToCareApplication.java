package br.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ToCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToCareApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "WebApp toCare";
	}

}
