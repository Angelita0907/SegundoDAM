export enum UserRole {
  STUDENT = 'STUDENT',
  TEACHER = 'TEACHER',
  PARENT = 'PARENT',
  ADMIN = 'ADMIN'
}

export interface User {
  id: string;
  nombre: string;
  email: string;
  rol: UserRole;
  nivel: string;  // Nivel lector determinado por la prueba inicial
  logros: string[];  // IDs de logros obtenidos
  fechaRegistro: Date;
  avatar?: string;
}

export interface UserStats {
  userId: string;
  velocidadLectura: number;  // palabras por minuto
  comprensionMedia: number;  // porcentaje
  librosCompletados: number;
  tiempoTotalLectura: number;  // en minutos
  racha: number;  // días consecutivos leyendo
  ultimaActividad: Date;
}
