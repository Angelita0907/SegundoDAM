import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { UserStats } from '../models/user.model';

export interface ReadingProgress {
  fecha: Date;
  minutos: number;
  paginas: number;
}

export interface ComprehensionData {
  mes: string;
  porcentaje: number;
}

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  getUserStats(userId: string): Observable<UserStats> {
    // Datos de ejemplo - reemplazar con llamada al backend
    const stats: UserStats = {
      userId,
      velocidadLectura: 245,  // palabras por minuto
      comprensionMedia: 78,   // porcentaje
      librosCompletados: 12,
      tiempoTotalLectura: 1850,  // minutos
      racha: 7,  // días consecutivos
      ultimaActividad: new Date()
    };

    return of(stats).pipe(delay(500));
  }

  getReadingProgress(userId: string, days: number = 30): Observable<ReadingProgress[]> {
    // Generar datos de ejemplo
    const progress: ReadingProgress[] = [];
    const today = new Date();

    for (let i = days - 1; i >= 0; i--) {
      const fecha = new Date(today);
      fecha.setDate(fecha.getDate() - i);
      
      progress.push({
        fecha,
        minutos: Math.floor(Math.random() * 90) + 10,  // 10-100 minutos
        paginas: Math.floor(Math.random() * 40) + 5    // 5-45 páginas
      });
    }

    return of(progress).pipe(delay(500));
  }

  getComprehensionTrend(userId: string): Observable<ComprehensionData[]> {
    // Datos de ejemplo de los últimos 6 meses
    const meses = ['Ago', 'Sep', 'Oct', 'Nov', 'Dic', 'Ene'];
    const data: ComprehensionData[] = meses.map((mes, index) => ({
      mes,
      porcentaje: 65 + Math.floor(Math.random() * 20) + index * 2  // Tendencia al alza
    }));

    return of(data).pipe(delay(500));
  }

  getWeeklyActivity(userId: string): Observable<{ dia: string; activo: boolean }[]> {
    const dias = ['Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb', 'Dom'];
    const activity = dias.map(dia => ({
      dia,
      activo: Math.random() > 0.3  // 70% de probabilidad de estar activo
    }));

    return of(activity).pipe(delay(500));
  }
}
