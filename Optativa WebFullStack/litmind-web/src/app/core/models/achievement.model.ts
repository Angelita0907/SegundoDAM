export enum AchievementType {
  READING_SPEED = 'READING_SPEED',
  COMPREHENSION = 'COMPREHENSION',
  CONSISTENCY = 'CONSISTENCY',
  BOOKS_READ = 'BOOKS_READ',
  PARTICIPATION = 'PARTICIPATION'
}

export interface Achievement {
  id: string;
  nombre: string;
  descripcion: string;
  tipo: AchievementType;
  icono: string;
  requisito: number;  // Por ejemplo: 10 libros, 500 ppm, etc.
  puntos: number;
}

export interface UserAchievement {
  userId: string;
  achievementId: string;
  fechaObtenido: Date;
  progreso: number;  // 0-100
}
