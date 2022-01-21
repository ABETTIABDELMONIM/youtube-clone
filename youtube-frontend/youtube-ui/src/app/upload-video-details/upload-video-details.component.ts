import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatChipInputEvent } from '@angular/material/chips';
import {COMMA, ENTER} from '@angular/cdk/keycodes';

@Component({
  selector: 'app-upload-video-details',
  templateUrl: './upload-video-details.component.html',
  styleUrls: ['./upload-video-details.component.css']
})
export class UploadVideoDetailsComponent implements OnInit {
  savedVideoDetailsForm:FormGroup;
  title : FormControl = new FormControl('');
  description : FormControl = new FormControl('');
  videoStatus : FormControl = new FormControl('');
  selectable = true;
  removable = true;
  addOnBlur = true;
  vgMedia:any;
  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  tags: string[] = [];

  constructor() {
    this.savedVideoDetailsForm = new FormGroup({
        title:this.title,
        description:this.description,
        videoStatus:this.videoStatus,
    });
   }

  ngOnInit(): void {
  }


  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();

    // Add our string
    if (value) {
      this.tags.push(value);
    }

    // Clear the input value
    event.chipInput!.clear();
  }

  remove(value: string): void {
    const index = this.tags.indexOf(value);

    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }

}
