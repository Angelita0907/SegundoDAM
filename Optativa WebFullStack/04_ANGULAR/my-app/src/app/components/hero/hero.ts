import { Component } from '@angular/core';
import { Heroes } from '../heroes/heroes';

@Component({
  selector: 'app-hero',
  imports: [Heroes],
  templateUrl: './hero.html',
  styleUrl: './hero.css',
})
export class Hero {

}
