export interface Lectura {
  _id?: string;
  titulo: string;
  genero: string;
  nivel: 'principiante' | 'intermedio' | 'avanzado';
  resena: string;
}

export interface Actividad {
  _id?: string;
  id_usuario: string;
  id_lectura: string;
  titulo_lectura: string;
  puntuacion: number;
  fecha: string;
  completada: boolean;
}
