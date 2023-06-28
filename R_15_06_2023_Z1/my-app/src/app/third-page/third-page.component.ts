import { Component } from '@angular/core';

@Component({
  selector: 'app-third-page',
  templateUrl: './third-page.component.html',
  styleUrls: ['./third-page.component.css']
})
export class ThirdPageComponent {
  firstNumber: number = 0;
  secondNumber: number = 0;
  operator: string = '+';

  calculateResult(): number {
    let result: number;
    switch (this.operator) {
      case 'add':
        result = this.firstNumber + this.secondNumber;
        break;
      case 'subtract':
        result = this.firstNumber - this.secondNumber;
        break;
      case 'multiply':
        result = this.firstNumber * this.secondNumber;
        break;
      case 'divide':
        result = this.firstNumber / this.secondNumber;
        break;
      default:
        result = 0;
        break;
    }
    return result;
  }
}
