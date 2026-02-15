import { Injectable, signal } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { delay, tap } from 'rxjs/operators';
import { User, UserRole } from '../models/user.model';

export interface LoginCredentials {
  email: string;
  password: string;
}

export interface RegisterData {
  nombre: string;
  email: string;
  password: string;
  rol: UserRole;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserSignal = signal<User | null>(null);
  private readonly STORAGE_KEY = 'litmind_user';

  constructor() {
    this.loadUserFromStorage();
  }

  get currentUser() {
    return this.currentUserSignal.asReadonly();
  }

  get isAuthenticated(): boolean {
    return this.currentUserSignal() !== null;
  }

  login(credentials: LoginCredentials): Observable<User> {
    // Simulación de login - reemplazar con llamada real al backend
    if (credentials.email === 'test@litmind.com' && credentials.password === 'test123') {
      const user: User = {
        id: '1',
        nombre: 'Usuario Demo',
        email: credentials.email,
        rol: UserRole.STUDENT,
        nivel: 'INTERMEDIATE',
        logros: [],
        fechaRegistro: new Date()
      };

      return of(user).pipe(
        delay(1000),
        tap(user => this.setUser(user))
      );
    }

    return throwError(() => new Error('Credenciales incorrectas')).pipe(delay(1000));
  }

  register(data: RegisterData): Observable<User> {
    // Simulación de registro - reemplazar con llamada real al backend
    const user: User = {
      id: Math.random().toString(36).substr(2, 9),
      nombre: data.nombre,
      email: data.email,
      rol: data.rol,
      nivel: 'BASIC',  // Se determinará con la prueba de nivel
      logros: [],
      fechaRegistro: new Date()
    };

    return of(user).pipe(
      delay(1000),
      tap(user => this.setUser(user))
    );
  }

  logout(): void {
    this.currentUserSignal.set(null);
    localStorage.removeItem(this.STORAGE_KEY);
  }

  private setUser(user: User): void {
    this.currentUserSignal.set(user);
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(user));
  }

  private loadUserFromStorage(): void {
    const userJson = localStorage.getItem(this.STORAGE_KEY);
    if (userJson) {
      try {
        const user = JSON.parse(userJson);
        this.currentUserSignal.set(user);
      } catch (error) {
        console.error('Error loading user from storage:', error);
        localStorage.removeItem(this.STORAGE_KEY);
      }
    }
  }
}
