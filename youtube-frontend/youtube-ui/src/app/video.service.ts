import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UploadVideoDetailsComponent } from './upload-video-details/upload-video-details.component';
import { UploadVideoResponse } from './UploadVideoResponse';

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  constructor(private httpClient:HttpClient,private router:Router) { }

  uploadViedo(file:File){
    const formData = new FormData()
    formData.append('file', file, file.name)
    this.httpClient.post<UploadVideoResponse>('http://localhost:8080/api/videos',formData)
      .subscribe(data =>{
        console.log('File uploaded successfully ',data);
        this.router.navigateByUrl("/upload-video-details/"+data.videoId)

      })

  }
}
