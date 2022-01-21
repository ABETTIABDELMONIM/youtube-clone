package com.youtube.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")

public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String fullName;
	private String emailAdress;
	private Set<String> subscribedToUsers;
	private Set<String> subscribers;
	private List<String> videoHistory;
	private Set<String> likedVideos;
	private Set<String> dislikedVideos;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public Set<String> getSubscribedToUsers() {
		return subscribedToUsers;
	}
	public void setSubscribedToUsers(Set<String> subscribedToUsers) {
		this.subscribedToUsers = subscribedToUsers;
	}
	public Set<String> getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(Set<String> subscribers) {
		this.subscribers = subscribers;
	}
	public List<String> getVideoHistory() {
		return videoHistory;
	}
	public void setVideoHistory(List<String> videoHistory) {
		this.videoHistory = videoHistory;
	}
	public Set<String> getLikedVideos() {
		return likedVideos;
	}
	public void setLikedVideos(Set<String> likedVideos) {
		this.likedVideos = likedVideos;
	}
	public Set<String> getDislikedVideos() {
		return dislikedVideos;
	}
	public void setDislikedVideos(Set<String> dislikedVideos) {
		this.dislikedVideos = dislikedVideos;
	}
	
	

}
