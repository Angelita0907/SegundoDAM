import { Injectable } from '@angular/core';
import { Actividad } from '../models/lectura.model';

@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  private actividadList: Actividad[] = [
    { _id: '1', id_usuario: '2', id_lectura: '1', titulo_lectura: 'El Principito', puntuacion: 85, fecha: '2026-02-10', completada: true },
    { _id: '2', id_usuario: '2', id_lectura: '2', titulo_lectura: 'Harry Potter y la piedra filosofal', puntuacion: 70, fecha: '2026-02-15', completada: true },
    { _id: '3', id_usuario: '2', id_lectura: '3', titulo_lectura: 'El nombre del viento', puntuacion: 0, fecha: '2026-02-20', completada: false },
    { _id: '4', id_usuario: '4', id_lectura: '1', titulo_lectura: 'El Principito', puntuacion: 95, fecha: '2026-01-20', completada: true },
    { _id: '5', id_usuario: '4', id_lectura: '4', titulo_lectura: 'Sapiens', puntuacion: 90, fecha: '2026-02-05', completada: true },
    { _id: '6', id_usuario: '5', id_lectura: '5', titulo_lectura: 'La sombra del viento', puntuacion: 78, fecha: '2026-02-12', completada: true },
    { _id: '7', id_usuario: '5', id_lectura: '3', titulo_lectura: 'El nombre del viento', puntuacion: 0, fecha: '2026-02-22', completada: false },
  ];

  getByUsuario(idUsuario: string): Actividad[] {
    return this.actividadList.filter(a => a.id_usuario === idUsuario);
  }

  getAll(): Actividad[] {
    return [...this.actividadList];
  }
}
