import { Component } from '@angular/core';
import { LocalStorageServiceService } from '../local-storage-service.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent {
  public firstForm : FormGroup;
  array: any[] = [];

  constructor(private formBuilder: FormBuilder, private localStorageService: LocalStorageServiceService) {
    this.firstForm = formBuilder.group({
      name : [null, Validators.required],
      lastName: [null, Validators.required],
      email: [null, Validators.email]
    });
   }

  submitForm() {
    const data = {
      name: this.firstForm.value.name,
      lastName:  this.firstForm.value.lastName,
      email:  this.firstForm.value.email,
    };
    this.array.push(data);
    // save to localstorage
    const jsonData = JSON.stringify(this.array);
    localStorage.setItem('KEY', jsonData);
    this.firstForm.reset();
  }
}
