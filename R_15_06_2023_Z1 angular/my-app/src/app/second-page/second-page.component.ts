import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-second-page',
  templateUrl: './second-page.component.html',
  styleUrls: ['./second-page.component.css']
})
export class SecondPageComponent {

  public secondForm: FormGroup;
  posts!: any[];

  constructor(private formBuilder: FormBuilder, private http: HttpClient){
    this.secondForm = formBuilder.group({
      id : [1, Validators.required]
    });
  }

  loadData(){
    const url = `https://jsonplaceholder.typicode.com/posts?userId=${this.secondForm.value.id}`;
    this.http.get<any[]>(url).subscribe(data => {
      this.posts = data;
    });
  }
}
