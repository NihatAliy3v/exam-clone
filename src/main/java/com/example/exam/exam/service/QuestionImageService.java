package com.example.exam.exam.service;

import com.example.exam.exam.dao.entity.Image;
import com.example.exam.exam.dao.entity.QuestionImageEntity;
import com.example.exam.exam.dao.repository.ImageRepository;
import com.example.exam.exam.dao.repository.LogMessageRepository;
import com.example.exam.exam.dao.repository.QuestionImageRepository;
import com.example.exam.exam.mapper.ImageMapper;
import com.example.exam.exam.mapper.QuestionImageMapper;
import com.example.exam.exam.model.RequestDto.ImageRequestDto;
import com.example.exam.exam.model.RequestDto.QuestionImageRequestDto;
import com.example.exam.exam.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class QuestionImageService {

    private final QuestionImageRepository imageRepository;
    private final QuestionImageMapper imageMapper;
    private final LogMessageRepository logMessageRepository;

        public void uploadImage(MultipartFile imageFile,Long questionId) throws IOException {


            var imageToSave = QuestionImageRequestDto.builder()
                    .name(imageFile.getOriginalFilename())
                    .type(imageFile.getContentType())
                    .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                    .url("http://localhost:8083/v1/question/image/" + imageFile.getOriginalFilename())
                    .questionId(questionId)
                    .build();
            imageRepository.save(imageMapper.dtoToEntity(imageToSave));


    }

    public byte[] downloadImage(String imageName) {
        Optional<QuestionImageEntity> dbImage = imageRepository.findByName(imageName);

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}