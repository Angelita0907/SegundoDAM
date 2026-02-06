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
  loading: boolean = true;
  error: string = '';

  constructor(private pokemonService: PokemonService) { }

  ngOnInit(): void {
    this.loadPokemon();
  }

  loadPokemon(): void {
    this.loading = true;
    this.pokemonService.getPokemon().subscribe({
      next: (data) => {
        this.pokemonList = data;
        this.loading = false;
      },
      error: (error) => {
        console.error('Error al cargar pokemon:', error);
        this.error = 'Error al cargar los pokemon';
        this.loading = false;
      }
    });
  }

  deletePokemon(id: string | undefined): void {
    if (!id) return;
    
    if (confirm('¿Estás seguro de que quieres eliminar este Pokémon?')) {
      this.pokemonService.deletePokemon(id).subscribe({
        next: (response) => {
          if (response.estado) {
            alert(response.mensaje);
            this.loadPokemon(); // Recargar la lista
          } else {
            alert(response.mensaje);
          }
        },
        error: (error) => {
          console.error('Error al eliminar pokemon:', error);
          alert('Error al eliminar el Pokémon');
        }
      });
    }
  }
}
