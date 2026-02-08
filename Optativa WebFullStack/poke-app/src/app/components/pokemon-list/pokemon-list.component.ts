import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../models/pokemon.model';

@Component({
  selector: 'app-pokemon-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './pokemon-list.component.html',
  styleUrls: ['./pokemon-list.component.css']
})
export class PokemonListComponent implements OnInit {
  pokemonList: Pokemon[] = [];

  constructor(private pokemonService: PokemonService) { }

  ngOnInit(): void {
    this.loadPokemon();
  }

  loadPokemon(): void {
    this.pokemonList = this.pokemonService.getAll();
  }

  deletePokemon(id: string | undefined): void {
    if (!id) return;
    
    if (confirm('¿Estás seguro de que quieres eliminar este Pokémon?')) {
      const success = this.pokemonService.delete(id);
      if (success) {
        alert('Pokémon eliminado correctamente');
        this.loadPokemon();
      } else {
        alert('Error al eliminar el Pokémon');
      }
    }
  }
}
