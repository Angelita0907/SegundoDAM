import { Injectable } from '@angular/core';
import { Lectura } from '../models/lectura.model';

@Injectable({
  providedIn: 'root'
})
export class LecturaService {

  private lecturaList: Lectura[] = [
    { _id: '1', titulo: 'El Principito', genero: 'Fábula', nivel: 'principiante', resena: 'Un clásico sobre la amistad y los valores humanos narrado a través de un pequeño príncipe que viaja por el universo.' },
    { _id: '2', titulo: 'Harry Potter y la piedra filosofal', genero: 'Fantasía', nivel: 'principiante', resena: 'La historia de un joven mago que descubre su destino al ingresar a la escuela de magia Hogwarts.' },
    { _id: '3', titulo: 'El nombre del viento', genero: 'Fantasía épica', nivel: 'intermedio', resena: 'Las memorias de Kvothe, el mago más famoso de su época, narradas por él mismo en primera persona.' },
    { _id: '4', titulo: 'Sapiens', genero: 'No ficción', nivel: 'avanzado', resena: 'Una breve historia de la humanidad que explora cómo los humanos conquistaron el mundo.' },
    { _id: '5', titulo: 'La sombra del viento', genero: 'Misterio', nivel: 'intermedio', resena: 'Un joven descubre un libro misterioso en el Cementerio de los Libros Olvidados en la Barcelona de posguerra.' }
  ];

  private nextId = 6;

  getAll(): Lectura[] {
    return [...this.lecturaList];
  }

  getById(id: string): Lectura | undefined {
    return this.lecturaList.find(l => l._id === id);
  }

  create(lectura: Lectura): Lectura {
    const nueva: Lectura = { ...lectura, _id: this.nextId.toString() };
    this.lecturaList.push(nueva);
    this.nextId++;
    return nueva;
  }

  update(id: string, lectura: Lectura): boolean {
    const index = this.lecturaList.findIndex(l => l._id === id);
    if (index !== -1) {
      this.lecturaList[index] = { ...lectura, _id: id };
      return true;
    }
    return false;
  }

  delete(id: string): boolean {
    const index = this.lecturaList.findIndex(l => l._id === id);
    if (index !== -1) {
      this.lecturaList.splice(index, 1);
      return true;
    }
    return false;
  }
}
