import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuarioList: Usuario[] = [
    {
      _id: '1',
      nombre: 'Admin LitMind',
      email: 'admin@litmind.app',
      password: 'admin123',
      rol: 'admin',
      nivel: 'avanzado',
      foto: 'https://profile-images.xing.com/images/9d9b4037529e6bcb547e642a2ff5597a-2/fco-javier-prada-oliva.1024x1024.jpg',
      logros: ['Administrador']
    },
    {
      _id: '2',
      nombre: 'Diego Garcia',
      email: 'diego@litmind.app',
      password: '1234',
      rol: 'estudiante',
      nivel: 'principiante',
      foto: 'https://media.themoviedb.org/t/p/w235_and_h235_face/qFek0KqpaPV5mVyHHNfAapDE9Tj.jpg',
      logros: ['Lector Novato']
    },
    {
      _id: '3',
      nombre: 'Ana Martinez',
      email: 'ana@litmind.app',
      password: '1234',
      rol: 'padre',
      nivel: 'intermedio',
      foto: 'https://upload.wikimedia.org/wikipedia/commons/0/03/Anne_Hathaway_at_The_Apprentice_in_NYC_03_%28cropped2%29.jpg',
      logros: ['Padre Activo']
    },
    {
      _id: '4',
      nombre: 'Laura Sanchez',
      email: 'laura@litmind.app',
      password: '1234',
      rol: 'profesor',
      nivel: 'avanzado',
      foto: 'https://media.themoviedb.org/t/p/w235_and_h235_face/qYNofOjlRke2MlJVihmJmEdQI4v.jpg',
      logros: ['Docente', 'Lector Experto']
    },
    {
      _id: '5',
      nombre: 'Carlos Ruiz',
      email: 'carlos@litmind.app',
      password: '1234',
      rol: 'estudiante',
      nivel: 'intermedio',
      foto: 'https://www.panoramaaudiovisual.com/wp-content/uploads/2025/10/Guillermo-del-Toro-headshot-credit-John-Wilson_Netflix.jpg',
      logros: ['Lector Constante', 'Comprension Veloz']
    }
  ];

  private nextId = 6;

  getAll(): Usuario[] {
    return [...this.usuarioList];
  }

  getById(id: string): Usuario | undefined {
    return this.usuarioList.find(u => u._id === id);
  }

  create(usuario: Usuario): Usuario {
    const nuevo: Usuario = { ...usuario, _id: this.nextId.toString() };
    this.usuarioList.push(nuevo);
    this.nextId++;
    return nuevo;
  }

  update(id: string, usuario: Usuario): boolean {
    const index = this.usuarioList.findIndex(u => u._id === id);
    if (index !== -1) {
      this.usuarioList[index] = { ...usuario, _id: id };
      return true;
    }
    return false;
  }

  delete(id: string): boolean {
    const index = this.usuarioList.findIndex(u => u._id === id);
    if (index !== -1) {
      this.usuarioList.splice(index, 1);
      return true;
    }
    return false;
  }
}
