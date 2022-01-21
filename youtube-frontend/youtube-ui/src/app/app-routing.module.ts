import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UploadVideoDetailsComponent } from './upload-video-details/upload-video-details.component';
import { UploadVideoComponent } from './upload-video/upload-video.component';

const routes: Routes = [
  {path:'upload-video',component:UploadVideoComponent},
  {path:'upload-video-details/:videoId',component:UploadVideoDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
