package com.youtube.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.UploadVideoResponseDto;
import com.youtube.service.VideoService;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
	
	private final  VideoService videoService;
	
	public VideoController(VideoService videoService) {
		super();
		this.videoService = videoService;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public UploadVideoResponseDto uploadVideo(@RequestParam("file") MultipartFile file ) {
		
		return videoService.uploadVideo(file);
		
	}
	@PutMapping
	@ResponseStatus(value = HttpStatus.OK)
	public VideoDto editVideoMeta(@RequestBody VideoDto videoDto){
		return videoService.editVideo(videoDto);
	 }
}
