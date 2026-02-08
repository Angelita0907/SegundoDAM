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

  constructor(
    private pokemonService: PokemonService,
    private router: Router
  ) { }

  onSubmit(): void {
    if (!this.pokemon.nombre || !this.pokemon.tipo || !this.pokemon.descripcion) {
      alert('Todos los campos son obligatorios');
      return;
    }

    this.pokemonService.create(this.pokemon);
    alert('¡Pokémon creado exitosamente!');
    this.router.navigate(['/pokemon']);
  }

  onCancel(): void {
    this.router.navigate(['/pokemon']);
  }
}
