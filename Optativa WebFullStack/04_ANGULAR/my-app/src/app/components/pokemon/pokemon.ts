import { Component, inject } from '@angular/core';
import { Pokemones } from '../pokemones/pokemones';
import { PokemonsInterface } from '../pokemons-interface';
import { CommonModule } from '@angular/common';
import { PokemonsService } from '../pokemons-service';
@Component({
  selector: 'app-pokemon',
  imports: [CommonModule,Pokemones],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css',
})
export class Pokemon {

  pokemoneslist:PokemonsInterface [] = []

  // metemos los datos del servicio en la pagina para mostrar los pokemons
  pokemonsService:PokemonsService = inject(PokemonsService);

}
