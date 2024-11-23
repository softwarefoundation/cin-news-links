package br.com.devchampions.hotlink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class AppHotlinkApplication {

	public static void main(String[] args) {
//		init();
		SpringApplication.run(AppHotlinkApplication.class, args);
	}


	private static void init(){
		List<String> senhas = new ArrayList<>();
		senhas.add("areta");
		senhas.add("ana");
		senhas.add("bruno");
		senhas.add("beatriz");
		senhas.add("camila");
		senhas.add("cintia");
		senhas.add("daniel");
		senhas.add("daniela");
		senhas.add("eder");
		senhas.add("emanuelle");
		senhas.add("fabiana");
		senhas.add("fabio");

		senhas.forEach(senha -> System.out.println(new BCryptPasswordEncoder().encode(senha)));

		System.out.println("----------------------------------------------------------------------------");
	}

}
