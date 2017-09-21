package com.astral;

import com.astral.schedule.ScheduleInitial;
import com.astral.schedule.TaskSchedule;
import com.astral.util.ResponseCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{

	public WebApplication(){
		super();   
	    setRegisterErrorPageFilter(true);
	}
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
