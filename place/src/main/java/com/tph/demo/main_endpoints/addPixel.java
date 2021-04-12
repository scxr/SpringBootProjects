package com.tph.demo.main_endpoints;

import com.tph.demo.Pixel.Pixel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
public class addPixel {




    @GetMapping("addpixel")
    public String mainAddGet(Model model) throws IOException {
//        System.out.println(img.setRGB(););
        model.addAttribute("pixel", new Pixel());
        return "addpixel";
    }

    @PostMapping("addpixel")
    public String mainAdd(@ModelAttribute("xval") Integer x, @ModelAttribute("yval") Integer y,@ModelAttribute("rgb") Integer rgb, Model model) throws IOException {
        BufferedImage img =  ImageIO.read(new File("src/main/resources/static/main.bmp"));
        img.setRGB(x, y, rgb);
        ImageIO.write(img, "bmp", new File("src/main/resources/static/main.bmp"));
        return "success";
    }
}
