package com.example.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AdvancedApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdvancedApplication.class, args);
    }
}

@RestController
@RequestMapping("/api")
class AdvancedController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Jenkins! Welcome to the Advanced Java App.";
    }

    @GetMapping("/time")
    public Map<String, String> getCurrentTime() {
        Map<String, String> response = new HashMap<>();
        response.put("serverTime", LocalDateTime.now().toString());
        return response;
    }

    @PostMapping("/message")
    public Map<String, String> receiveMessage(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("receivedMessage", request.get("message"));
        response.put("status", "Message processed successfully");
        return response;
    }
}
