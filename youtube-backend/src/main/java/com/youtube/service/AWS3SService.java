package com.youtube.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AWS3SService implements StorageService{
	
	
	
	private static final String BUCKET_NAME = "Here the bucket name";
	private final AmazonS3Client aws3Client ;
	

	public AWS3SService(AmazonS3Client aws3Client) {
		this.aws3Client = aws3Client;
	}


	@Override
	public String uploadFile(MultipartFile f) {
		var fileNameExtension = f.getOriginalFilename();
		var key = UUID.randomUUID() +"."+ fileNameExtension;
		var metaData=  new ObjectMetadata();
		metaData.setContentLength(f.getSize());
		metaData.setContentType(f.getContentType());
		
		try {
			aws3Client.putObject(BUCKET_NAME,key,f.getInputStream(),metaData);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An Exception occured while uploading the file");
		}
		aws3Client.setObjectAcl(BUCKET_NAME,key, CannedAccessControlList.PublicRead);
		return aws3Client.getResourceUrl(BUCKET_NAME,key);
		
	}
	

}
