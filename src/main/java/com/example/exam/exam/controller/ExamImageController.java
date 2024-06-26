package com.example.exam.exam.controller;

import com.example.exam.exam.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/v1/exam/image")
@RequiredArgsConstructor
public class ExamImageController {

    private final ImageService imageService;

    @PostMapping(consumes = "multipart/form-data", produces = "application/json")
    public void  uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("examId") Long examId,@RequestParam("nameUI") String nameUI) throws IOException {
        imageService.uploadImage(file,examId,nameUI);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
        byte[] imageData = imageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(IMAGE_PNG_VALUE))
                .body(imageData);
    }
}