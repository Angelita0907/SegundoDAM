import { Injectable } from '@angular/core';
import { Juguete } from '../models/juguete.model';

@Injectable({ providedIn: 'root' })
export class JugueteService {

  private juguetes: Juguete[] = [
    { id: 1, nombre: 'LEGO Señor de los Anillos', edadRecomendada: 16, precio: 49.99, imagen: 'https://www.lego.com/cdn/cs/set/assets/blt33d693d46b4b5858/10316_alt1.png', disponible: true },
    { id: 2, nombre: 'Barbie Castillo de Diamantes', edadRecomendada: 3, precio: 79.99, imagen: 'https://http2.mlstatic.com/D_NQ_NP_741488-MLM90670527585_082025-O.webp', disponible: true },
    { id: 3, nombre: 'LalaLoopsy', edadRecomendada: 4, precio: 29.99, imagen: 'https://m.media-amazon.com/images/I/81HYa7-kwbS._AC_UF894,1000_QL80_.jpg', disponible: false },
    { id: 4, nombre: 'PinyPons', edadRecomendada: 6, precio: 24.99, imagen: 'https://www.toysrus.es/medias/?context=bWFzdGVyfHByb2R1Y3RfaW1hZ2VzfDMwNjM4fGltYWdlL2pwZWd8YURkakwyaGtOQzh4TkRVeU1UY3pPRE01TlRZM09BfGI5OTE1YWZmOWRkMTJjYThhM2RiYjllOWU0ZGVhMmY0NzZkZmY5ODZmZWU5ZDBlYmExZGI1OTM4MTVjNzcwZDY', disponible: true },
    { id: 5, nombre: 'Coche Rosita', edadRecomendada: 3, precio: 69.99, imagen: 'https://bizcochodeyogurshop.com/cdn/shop/files/mini-coche-de-juguete-beetle-clasical-rosa-bizcocho-de-yogur.jpg?v=1709596439', disponible: true },
  ];

  getAll(): Juguete[] {
    return [...this.juguetes];
  }

  getDisponibles(): Juguete[] {
    return this.juguetes.filter(j => j.disponible);
  }
}