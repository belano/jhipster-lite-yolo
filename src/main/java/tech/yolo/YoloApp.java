package tech.yolo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import tech.yolo.common.domain.Generated;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class YoloApp {

  private static final Logger log = LoggerFactory.getLogger(YoloApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(YoloApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
