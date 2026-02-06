import { Component } from '@angular/core';
import { Pokemones } from '../pokemones/pokemones';

@Component({
  selector: 'app-pokemon',
  imports: [Pokemones],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css',
})
export class Pokemon {

}
