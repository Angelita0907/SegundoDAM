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
  error: string = '';
  loading: boolean = true;
  saving: boolean = false;

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
    this.pokemonService.getPokemonById(this.pokemonId).subscribe({
      next: (data) => {
        this.pokemon = data;
        this.loading = false;
      },
      error: (error) => {
        console.error('Error al cargar pokemon:', error);
        this.error = 'Pokémon no encontrado';
        this.loading = false;
      }
    });
  }

  onSubmit(): void {
    if (!this.pokemon.nombre || !this.pokemon.tipo || !this.pokemon.descripcion) {
      this.error = 'Todos los campos son obligatorios';
      return;
    }

    this.saving = true;
    this.error = '';

    this.pokemonService.updatePokemon(this.pokemonId, this.pokemon).subscribe({
      next: (response) => {
        if (response.estado) {
          alert(response.mensaje);
          this.router.navigate(['/pokemon']);
        } else {
          this.error = response.mensaje;
          this.saving = false;
        }
      },
      error: (error) => {
        console.error('Error al actualizar pokemon:', error);
        this.error = 'Error al actualizar el Pokémon';
        this.saving = false;
      }
    });
  }

  deletePokemon(): void {
    if (confirm('¿Estás seguro de que quieres eliminar este Pokémon?')) {
      this.pokemonService.deletePokemon(this.pokemonId).subscribe({
        next: (response) => {
          if (response.estado) {
            alert(response.mensaje);
            this.router.navigate(['/pokemon']);
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

  onCancel(): void {
    this.router.navigate(['/pokemon']);
  }
}
