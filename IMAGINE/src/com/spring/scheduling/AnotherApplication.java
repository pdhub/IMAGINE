package com.spring.scheduling;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
@EnableScheduling
class Application {

	{
		System.out.println("init");
	}

	static {
		System.out.println("Static");
	}

	public Application() {
		System.out.println("cons");
	}

}

public class AnotherApplication extends Application {

	{
		System.out.println("Another init");
	}

	static {
		System.out.println("Another Static");
	}

	public AnotherApplication() {
		System.out.println("AnotherApplication cons");
	}

	public static void main(String[] args) throws Exception {
		new AnotherApplication();
	}
	
	{
		System.out.println("Another init2");
	}
}