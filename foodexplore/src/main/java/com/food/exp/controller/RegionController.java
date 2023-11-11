package com.food.exp.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionController {

    @GetMapping("/regions")
    public String getRegion(Model model) {
        try {
            // JSON 파일 읽기
            Resource resource = new ClassPathResource("region.json");
            byte[] jsonData = StreamUtils.copyToByteArray(resource.getInputStream());
            String jsonString = new String(jsonData);

            // jsonString을 모델에 추가
            model.addAttribute("jsonData", jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "main.html";
    }
}

