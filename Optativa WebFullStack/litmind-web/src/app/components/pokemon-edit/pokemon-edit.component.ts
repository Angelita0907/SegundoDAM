import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../models/pokemon.model';

@Component({
  selector: 'app-pokemon-edit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pokemon-edit.component.html',
  styleUrls: ['./pokemon-edit.component.css']
})
export class PokemonEditComponent implements OnInit {
  pokemon: Pokemon = {
    nombre: '',
    tipo: '',
    descripcion: ''
  };

  pokemonId: string = '';
  notFound: boolean = false;

  constructor(
    private pokemonService: PokemonService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.pokemonId = this.route.snapshot.params['id'];
    this.loadPokemon();
  }

  loadPokemon(): void {
    const found = this.pokemonService.getById(this.pokemonId);
    if (found) {
      this.pokemon = { ...found };
    } else {
      this.notFound = true;
    }
  }

  onSubmit(): void {
    if (!this.pokemon.nombre || !this.pokemon.tipo || !this.pokemon.descripcion) {
      alert('Todos los campos son obligatorios');
      return;
    }

    const success = this.pokemonService.update(this.pokemonId, this.pokemon);
    if (success) {
      alert('¡Pokémon actualizado!');
      this.router.navigate(['/pokemon']);
    } else {
      alert('Error al actualizar el Pokémon');
    }
  }

  deletePokemon(): void {
    if (confirm('¿Estás seguro de que quieres eliminar este Pokémon?')) {
      const success = this.pokemonService.delete(this.pokemonId);
      if (success) {
        alert('Pokémon eliminado correctamente');
        this.router.navigate(['/pokemon']);
      } else {
        alert('Error al eliminar el Pokémon');
      }
    }
  }

  onCancel(): void {
    this.router.navigate(['/pokemon']);
  }
}
