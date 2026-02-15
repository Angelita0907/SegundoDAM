export enum ReadingLevel {
  BASIC = 'BASIC',
  INTERMEDIATE = 'INTERMEDIATE',
  ADVANCED = 'ADVANCED',
  EXPERT = 'EXPERT'
}

export interface Reading {
  id: string;
  titulo: string;
  genero: string;
  nivel: ReadingLevel;
  contenido: string;
  reseña: string;
  portada?: string;
  autor?: string;
  duracionEstimada: number;  // en minutos
}

export interface ReadingActivity {
  id: string;
  userId: string;
  readingId: string;
  fechaInicio: Date;
  fechaFin?: Date;
  puntuacion?: number;
  comprension?: number;
  velocidad?: number;
  completado: boolean;
}

export interface Exercise {
  id: string;
  readingId: string;
  tipo: 'multiple_choice' | 'true_false' | 'open_question';
  pregunta: string;
  opciones?: string[];
  respuestaCorrecta: string;
  explicacion?: string;
}
