import { Injectable } from '@angular/core';
import { PokemonsInterface } from './pokemons-interface';

@Injectable({
  providedIn: 'root',
})
export class PokemonsService {
  readonly baseUrl = 'https://images.wikidexcdn.net/mwuploads/wikidex';

  title: string = "Mira Mis Pokemons Que Guapos"
  pokemoneslist:PokemonsInterface [] = [
    {

    id: 1,
    name: 'shaymin',
    type: 'Planta',
    description: ' Shaymin está basado en un erizo y un ramillete de flores. Su piel es blanca y en vez de espinas, a Shaymin le crece hierba verde sobre su espalda.',
    photo : `${this.baseUrl}/8/86/latest/20150601121800/Shaymin_tierra.png`
  },
  {
    id: 2,
    name: 'Charmander',
    type: 'Fuego',
    description: 'Charmander es un pequeño lagarto bípedo. La llama en la punta de su cola indica su salud y estado emocional; si se apaga, el Pokémon muere. Prefiere los lugares calurosos.',
    photo: `${this.baseUrl}/5/56/latest/20200307023245/Charmander.png`
  },
  {
    id: 3,
    name: 'Squirtle',
    type: 'Agua',
    description: 'Squirtle es una pequeña tortuga de color azul. Su caparazón no solo lo protege, sino que su forma hidrodinámica le permite nadar a altas velocidades lanzando chorros de agua.',
    photo: `${this.baseUrl}/e/e3/latest/20160309230820/Squirtle.png`
  },
  {
    id: 4,
    name: 'Pikachu',
    type: 'Eléctrico',
    description: 'Pikachu almacena electricidad en las mejillas rojas de su cara. Cuando se siente amenazado, descarga esta energía. Es conocido por ser el compañero más fiel de los entrenadores.',
    photo: `${this.baseUrl}/7/77/latest/20150621181250/Pikachu.png`
  },
  {
    id: 5,
    name: 'Eevee',
    type: 'Normal',
    description: 'Eevee es un Pokémon con una estructura genética irregular que le permite evolucionar en múltiples formas dependiendo de su entorno y los estímulos que reciba.',
    photo: `${this.baseUrl}/eevee.jpg`
  },
  {
    id: 6,
    name: 'Mewtwo',
    type: 'Psíquico',
    description: 'Mewtwo fue creado mediante manipulación genética a partir del ADN de Mew. Es conocido por su inmenso poder psíquico y su naturaleza solitaria y reflexiva.',
    photo: `${this.baseUrl}/d/d3/latest/20190408034831/Mewtwo.png`
  },
  {
    id: 7,
    name: 'Gengar',
    type: 'Fantasma/Veneno',
    description: 'Gengar se esconde en las sombras para acechar a su presa. Se dice que su presencia hace que la temperatura baje repentinamente y disfruta gastando bromas pesadas.',
    photo: `${this.baseUrl}/f/f8/latest/20200428203046/Gengar.png`
  },
  {
    id: 8,
    name: 'Snorlax',
    type: 'Normal',
    description: 'Snorlax es famoso por su enorme apetito y su capacidad para dormir profundamente. Su estómago puede digerir cualquier tipo de comida, incluso si está algo pasada.',
    photo: `${this.baseUrl}/snorlax.jpg`
  },
  {
    id: 9,
    name: 'Lucario',
    type: 'Lucha/Acero',
    description: 'Lucario tiene la habilidad única de detectar el aura de los seres vivos. Gracias a esto, puede leer los movimientos de sus oponentes y comunicarse con los humanos.',
    photo: `${this.baseUrl}/lucario.jpg`
  },
  {
    id: 10,
    name: 'Greninja',
    type: 'Agua/Siniestro',
    description: 'Greninja se mueve con la agilidad de un ninja. Utiliza estrellas ninja hechas de agua comprimida que pueden cortar incluso el metal más resistente.',
    photo: `${this.baseUrl}/greninja.jpg`
  }
  ]

  getAllPokemons(): PokemonsInterface[] {
    return this.pokemoneslist
  }

  

}
