package com.example.diploma.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class VideoController {

    @GetMapping(value = "video/stream")
    public ResponseEntity<InputStreamResource> streamVideo(HttpServletRequest request) throws IOException {
        ClassPathResource videoResource = new ClassPathResource("static/video/test.mp4");
        InputStream stream = videoResource.getInputStream();
        InputStreamResource resource = new InputStreamResource(stream);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .contentLength(videoResource.contentLength())
                .body(resource);
    }
}
