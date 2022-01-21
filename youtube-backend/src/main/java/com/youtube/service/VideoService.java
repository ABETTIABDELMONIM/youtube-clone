package com.youtube.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.youtube.UploadVideoResponseDto;
import com.youtube.controller.VideoDto;
import com.youtube.model.Video;
import com.youtube.repository.VideoRepository;

@Service
public class VideoService {
	
	private final AWS3SService aws3sService;
	private final VideoRepository videoRepository;
	
	
	public VideoService(AWS3SService aws3sService, VideoRepository videoRepository) {
		super();
		this.aws3sService = aws3sService;
		this.videoRepository = videoRepository;
	}


	public UploadVideoResponseDto uploadVideo(MultipartFile file) {
		//String videoUrl =  aws3sService.uploadFile(file);
		Video video = new Video();
	//	video.setVideoUrl(videoUrl);
		var savedVideo = videoRepository.save(video);
		return new UploadVideoResponseDto( savedVideo.getId(),null);
	}


    public VideoDto editVideo(VideoDto videoDto) {
		Video saveVideo = videoRepository.findById(videoDto.getId())
		.orElseThrow(()-> new IllegalArgumentException("Cannot find video by id -"+ videoDto.getId()));

		saveVideo.setTitle(videoDto.getTitle());
		saveVideo.setDescription(videoDto.getDescription());
		saveVideo.setTags(videoDto.getTags());
		saveVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
		saveVideo.setVideoStatus(videoDto.getVideoStatus());

		videoRepository.save(saveVideo);
		return videoDto;
    }
}
