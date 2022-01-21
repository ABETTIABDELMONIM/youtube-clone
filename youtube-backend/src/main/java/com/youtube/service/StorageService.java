package com.youtube.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	String uploadFile(MultipartFile f);
}
