package com.youtube;

public class UploadVideoResponseDto {
    private String videoId;
    private String videoUrl;
    public UploadVideoResponseDto(String videoId, String videoUrl) {
        this.videoId=videoId;
        this.videoUrl=videoUrl;

    }
    public String getVideoId() {
        return videoId;
    }
    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
   


}
