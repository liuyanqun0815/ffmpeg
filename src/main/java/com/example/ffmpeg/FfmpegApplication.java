package com.example.ffmpeg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FfmpegApplication {

    public static void main(String[] args) {
        SpringApplication.run(FfmpegApplication.class, args);
    }

}
