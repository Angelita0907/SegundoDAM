import { Injectable } from '@angular/core';
import { Pokemon } from '../models/pokemon.model';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private pokemonList: Pokemon[] = [
    {
      _id: '1',
      nombre: 'Pikachu',
      tipo: 'Eléctrico',
      descripcion: 'Un Pokémon de tipo eléctrico muy popular'
    },
    {
      _id: '2',
      nombre: 'Charmander',
      tipo: 'Fuego',
      descripcion: 'Un Pokémon de tipo fuego con cola en llamas'
    },
    {
      _id: '3',
      nombre: 'Squirtle',
      tipo: 'Agua',
      descripcion: 'Un Pokémon tortuga de tipo agua'
    },
    {
      _id: '4',
      nombre: 'Bulbasaur',
      tipo: 'Planta/Veneno',
      descripcion: 'Un Pokémon con un bulbo en su espalda'
    }
  ];

  private nextId = 5;

  constructor() {
    
  }

  private saveToLocalStorage(): void {
    localStorage.setItem('pokemonList', JSON.stringify(this.pokemonList));
  }

  
  // Obtener todos los pokemon
  getAll(): Pokemon[] {
    return [...this.pokemonList];
  }

  // Obtener un pokemon por ID
  getById(id: string): Pokemon | undefined {
    return this.pokemonList.find(p => p._id === id);
  }


  // peticiones http con json

  url = 'http://localhost:3000/pokemons';
  async getAllPokemons(){
    const data = await fetch(this.url);
    return (await data.json());
  }

  async getAllPokemonsByNombre(nombre: string): Promise<Pokemon | undefined>{
    const data = await fetch(`${this.url}/${nombre}`);
    return (await data.json()) ?? {};
  }

  /* con "..." los usamos para referirnos a las variables del objeto 
  sin definir una por una, simplemnete llamamos al modelo*/

  // Crear un nuevo pokemon
  create(pokemon: Pokemon): Pokemon {
    const newPokemon: Pokemon = {
      ...pokemon,
      _id: this.nextId.toString()
    };
    
    this.pokemonList.push(newPokemon);
    this.nextId++;
    this.saveToLocalStorage();
    
    return newPokemon;
  }

  // Actualizar un pokemon
  update(id: string, pokemon: Pokemon): boolean {
    const index = this.pokemonList.findIndex(p => p._id === id);
    
    if (index !== -1) {
      this.pokemonList[index] = { ...pokemon, _id: id };
      this.saveToLocalStorage();
      return true;
    }
    return false;
  }

  // Eliminar un pokemon
  delete(id: string): boolean {
    const index = this.pokemonList.findIndex(p => p._id === id);
    
    if (index !== -1) {
      this.pokemonList.splice(index, 1);
      this.saveToLocalStorage();
      return true;
    }
    return false;
  }
}
