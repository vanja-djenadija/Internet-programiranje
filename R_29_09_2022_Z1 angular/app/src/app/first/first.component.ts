import { Component } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent {

  save() {
      console.log('Saving');
  }

  start() {
    console.log('Starting');
  }
}
