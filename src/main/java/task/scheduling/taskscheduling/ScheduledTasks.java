package task.scheduling.taskscheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 2000) // makes Spring run the task on periodic intervals even if the last invocation
                                 // may still be running.
    public void scheduledWithFixedRate() {
        LOGGER.info("Scheduled with fixed rate :: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(fixedDelay = 2000) // specifically controls the next execution time when the last execution
                                  // finishes.
    public void scheduledWithFixedDelay() {
        LOGGER.info("Scheduled with fixed delay :: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(initialDelay = 10000, fixedRate = 5000) // delay before the first execution of a fixedRate or fixedDelay
                                                       // task.
    public void scheduledWithInitialDelay() {
        LOGGER.info("Scheduled with initial delay and fixed rate :: {}",
                DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(cron=" 0 * * * * ? ") // from left to right : second minute hour day_of_month month day_of_week
    public void scheduledWithCronExpression() {
        LOGGER.info("Scheduled with cron expression :: {}",
        DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }
}
