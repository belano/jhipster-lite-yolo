package tech.yolo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tech.yolo.common.domain.Generated;

import java.math.BigDecimal;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class YoloApp {

  private static final Logger log = LoggerFactory.getLogger(YoloApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(YoloApp.class, args)
      .getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customizer() {
    return builder -> builder.modules(new MyModule());
  }

  // Allow serialization of BigDecimal as String, using @JsonFormat(shape=Shape.String), config overrides
  private static class MyModule extends SimpleModule {
    @Override
    public void setupModule(SetupContext context) {
      // Required, as documented in the Javadoc of SimpleModule
      super.setupModule(context);
      context.configOverride(BigDecimal.class)
        .setFormat(JsonFormat.Value.forShape(JsonFormat.Shape.STRING));
    }
  }
}
