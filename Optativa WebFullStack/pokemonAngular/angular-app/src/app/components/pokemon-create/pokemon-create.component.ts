import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../models/pokemon.model';

@Component({
  selector: 'app-pokemon-create',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pokemon-create.component.html',
  styleUrls: ['./pokemon-create.component.css']
})
export class PokemonCreateComponent {
  pokemon: Pokemon = {
    nombre: '',
    tipo: '',
    descripcion: ''
  };

  error: string = '';
  loading: boolean = false;

  constructor(
    private pokemonService: PokemonService,
    private router: Router
  ) { }

  onSubmit(): void {
    // Validación básica
    if (!this.pokemon.nombre || !this.pokemon.tipo || !this.pokemon.descripcion) {
      this.error = 'Todos los campos son obligatorios';
      return;
    }

    this.loading = true;
    this.error = '';

    this.pokemonService.createPokemon(this.pokemon).subscribe({
      next: (response) => {
        console.log('Pokemon creado:', response);
        alert('Pokémon creado exitosamente');
        this.router.navigate(['/pokemon']);
      },
      error: (error) => {
        console.error('Error al crear pokemon:', error);
        this.error = 'Error al crear el Pokémon';
        this.loading = false;
      }
    });
  }

  onCancel(): void {
    this.router.navigate(['/pokemon']);
  }
}
