import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent {
  firstForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.firstForm = formBuilder.group({});
  }
  save() {
    console.log('Saving');
  }

  start() {
    console.log('Starting');
  }
}
