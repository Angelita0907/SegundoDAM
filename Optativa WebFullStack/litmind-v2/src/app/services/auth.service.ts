import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuariosDePrueba: Usuario[] = [
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
      foto: 'https://api.dicebear.com/7.x/avataaars/svg?seed=diego&backgroundColor=c0aede',
      logros: ['Lector Novato']
    },
    {
      _id: '3',
      nombre: 'Ana Martinez',
      email: 'ana@litmind.app',
      password: '1234',
      rol: 'padre',
      nivel: 'intermedio',
      foto: 'https://api.dicebear.com/7.x/avataaars/svg?seed=ana&backgroundColor=d1f4d1',
      logros: ['Padre Activo']
    },
    {
      _id: '4',
      nombre: 'Laura Sanchez',
      email: 'laura@litmind.app',
      password: '1234',
      rol: 'profesor',
      nivel: 'avanzado',
      foto: 'https://api.dicebear.com/7.x/avataaars/svg?seed=laura&backgroundColor=ffd5dc',
      logros: ['Docente', 'Lector Experto']
    },
    {
      _id: '5',
      nombre: 'Carlos Ruiz',
      email: 'carlos@litmind.app',
      password: '1234',
      rol: 'estudiante',
      nivel: 'intermedio',
      foto: 'https://api.dicebear.com/7.x/avataaars/svg?seed=carlos&backgroundColor=ffdfbf',
      logros: ['Lector Constante', 'Comprension Veloz']
    }
  ];

  private usuarioActual: Usuario | null = null;

  login(email: string, password: string): boolean {
    const encontrado = this.usuariosDePrueba.find(
      u => u.email === email && u.password === password
    );
    if (encontrado) {
      this.usuarioActual = encontrado;
      return true;
    }
    return false;
  }

  logout(): void {
    this.usuarioActual = null;
  }

  getUsuarioActual(): Usuario | null {
    return this.usuarioActual;
  }

  isLoggedIn(): boolean {
    return this.usuarioActual !== null;
  }

  isAdmin(): boolean {
    return this.usuarioActual?.rol === 'admin';
  }
}
