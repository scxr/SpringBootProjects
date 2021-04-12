package com.tph.demo;

import com.tph.demo.main_endpoints.addPixel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CanvasdrawerApplication {
    private addPixel pixel = new addPixel();




    public CanvasdrawerApplication() throws IOException {
    }

    public static void main(String[] args) {
        SpringApplication.run(CanvasdrawerApplication.class, args);
    }

}
