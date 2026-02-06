import { Component, Input } from '@angular/core';
import { PokemonsInterface } from '../pokemons-interface';
@Component({
  selector: 'app-pokemones',
  imports: [],
  templateUrl: './pokemones.html',
  styleUrl: './pokemones.css',
})
export class Pokemones {

  @Input() pokemones!: PokemonsInterface;

}
