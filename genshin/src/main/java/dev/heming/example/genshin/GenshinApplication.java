package dev.heming.example.genshin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GenshinApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "启动！";
    }

}
