export interface Usuario {
  _id?: string;
  nombre: string;
  email: string;
  password: string;
  rol: 'admin' | 'estudiante' | 'profesor' | 'padre';
  nivel: 'principiante' | 'intermedio' | 'avanzado';
  foto: string; // URL de la foto de perfil
  logros?: string[];
}
