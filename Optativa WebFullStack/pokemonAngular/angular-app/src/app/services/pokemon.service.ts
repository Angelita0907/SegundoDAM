import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private apiUrl = `${environment.apiUrl}/pokemon`;

  constructor(private http: HttpClient) { }

  // Obtener todos los pokemon
  getPokemon(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>(this.apiUrl);
  }

  // Obtener un pokemon por ID
  getPokemonById(id: string): Observable<Pokemon> {
    return this.http.get<Pokemon>(`${this.apiUrl}/${id}`);
  }

  // Crear un nuevo pokemon
  createPokemon(pokemon: Pokemon): Observable<Pokemon> {
    return this.http.post<Pokemon>(this.apiUrl, pokemon);
  }

  // Actualizar un pokemon
  updatePokemon(id: string, pokemon: Pokemon): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, pokemon);
  }

  // Eliminar un pokemon
  deletePokemon(id: string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
