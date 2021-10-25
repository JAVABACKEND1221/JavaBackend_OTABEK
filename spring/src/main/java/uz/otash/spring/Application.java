package uz.otash.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Scheduled(fixedRate = 1000L)
//	public  void startRate(){
//		System.out.println("New rate " + new Date());
//	}
//
	@Scheduled(initialDelay = 1000L, fixedDelay = 2000L)
	public void startDelay(){
		System.out.println("New startDelay " + new Date());
	}

	@Scheduled(cron = "0 21 23 * * *")
	public void startCron(){
		System.out.println("New startCron " + new Date());
	}

}
