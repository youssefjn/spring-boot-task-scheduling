package task.scheduling.taskscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskSchedulingApplication.class, args);
	}

}
