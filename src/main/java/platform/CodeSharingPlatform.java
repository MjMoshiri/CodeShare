package platform;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class CodeSharingPlatform {

    @Bean
    public ArrayList<Code> codes(){
        return new ArrayList<>();
    }
    @Bean
    public Map<String, String> map(){
        return new HashMap();
    }

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {
        private final CodeRepository repository;

        public Runner(CodeRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) {

        }
    }
}
