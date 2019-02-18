package com.example.demo.web;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class FileUploadSampleForm implements Serializable {
	private MultipartFile uploadedFile;
}
