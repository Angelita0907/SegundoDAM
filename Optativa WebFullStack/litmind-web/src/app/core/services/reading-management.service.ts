import { Injectable } from '@angular/core';
import { Reading, ReadingLevel } from '@core/models/reading.model';

@Injectable({
  providedIn: 'root'
})
export class ReadingManagementService {
  private readingList: Reading[] = [
    {
      id: '1',
      titulo: 'El Principito',
      genero: 'Ficción',
      nivel: ReadingLevel.INTERMEDIATE,
      contenido: 'Una historia sobre un pequeño príncipe que viaja entre planetas...',
      resena: 'Un clásico de la literatura francesa que enseña valores importantes',
      autor: 'Antoine de Saint-Exupéry',
      duracionEstimada: 45,
      portada: 'https://via.placeholder.com/150/8575A2/FFFFFF?text=El+Principito'
    },
    {
      id: '2',
      titulo: 'Cien años de soledad',
      genero: 'Realismo mágico',
      nivel: ReadingLevel.ADVANCED,
      contenido: 'La historia de la familia Buendía a lo largo de varias generaciones...',
      resena: 'Obra maestra del realismo mágico latinoamericano',
      autor: 'Gabriel García Márquez',
      duracionEstimada: 180,
      portada: 'https://via.placeholder.com/150/75A285/FFFFFF?text=Cien+Años'
    },
    {
      id: '3',
      titulo: 'El gato con botas',
      genero: 'Cuento infantil',
      nivel: ReadingLevel.BASIC,
      contenido: 'Un gato astuto ayuda a su amo a conseguir fortuna y amor...',
      resena: 'Cuento clásico ideal para lectores principiantes',
      autor: 'Charles Perrault',
      duracionEstimada: 15,
      portada: 'https://via.placeholder.com/150/E5A865/FFFFFF?text=Gato+Botas'
    },
    {
      id: '4',
      titulo: 'Don Quijote de la Mancha',
      genero: 'Novela',
      nivel: ReadingLevel.EXPERT,
      contenido: 'Las aventuras del ingenioso hidalgo Don Quijote y su fiel escudero...',
      resena: 'La obra cumbre de la literatura española',
      autor: 'Miguel de Cervantes',
      duracionEstimada: 300,
      portada: 'https://via.placeholder.com/150/7595A2/FFFFFF?text=Don+Quijote'
    },
    {
      id: '5',
      titulo: 'La metamorfosis',
      genero: 'Ficción',
      nivel: ReadingLevel.ADVANCED,
      contenido: 'Gregor Samsa despierta convertido en un insecto gigante...',
      resena: 'Una reflexión profunda sobre la condición humana',
      autor: 'Franz Kafka',
      duracionEstimada: 60,
      portada: 'https://via.placeholder.com/150/A595C2/FFFFFF?text=Metamorfosis'
    }
  ];

  private nextId = 6;
  private readonly STORAGE_KEY = 'litmind_readings';

  constructor() {
    this.loadFromLocalStorage();
  }

  private saveToLocalStorage(): void {
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(this.readingList));
  }

  private loadFromLocalStorage(): void {
    const stored = localStorage.getItem(this.STORAGE_KEY);
    if (stored) {
      try {
        this.readingList = JSON.parse(stored);
        // Actualizar nextId basado en el máximo ID existente
        const maxId = Math.max(...this.readingList.map(r => parseInt(r.id) || 0));
        this.nextId = maxId + 1;
      } catch (error) {
        console.error('Error loading readings from localStorage:', error);
      }
    }
  }

  // Obtener todas las lecturas
  getAll(): Reading[] {
    return [...this.readingList];
  }

  // Obtener una lectura por ID
  getById(id: string): Reading | undefined {
    return this.readingList.find(r => r.id === id);
  }

  // Obtener lecturas por nivel
  getByLevel(level: ReadingLevel): Reading[] {
    return this.readingList.filter(r => r.nivel === level);
  }

  // Obtener lecturas por género
  getByGenre(genre: string): Reading[] {
    return this.readingList.filter(r => 
      r.genero.toLowerCase().includes(genre.toLowerCase())
    );
  }

  // Buscar lecturas por título o autor
  search(query: string): Reading[] {
    const lowerQuery = query.toLowerCase();
    return this.readingList.filter(r => 
      r.titulo.toLowerCase().includes(lowerQuery) ||
      (r.autor && r.autor.toLowerCase().includes(lowerQuery))
    );
  }

  // Crear una nueva lectura
  create(reading: Omit<Reading, 'id'>): Reading {
    const newReading: Reading = {
      ...reading,
      id: this.nextId.toString()
    };
    
    this.readingList.push(newReading);
    this.nextId++;
    this.saveToLocalStorage();
    
    return newReading;
  }

  // Actualizar una lectura
  update(id: string, reading: Partial<Reading>): boolean {
    const index = this.readingList.findIndex(r => r.id === id);
    
    if (index !== -1) {
      this.readingList[index] = { 
        ...this.readingList[index],
        ...reading,
        id // Mantener el ID original
      };
      this.saveToLocalStorage();
      return true;
    }
    return false;
  }

  // Eliminar una lectura
  delete(id: string): boolean {
    const index = this.readingList.findIndex(r => r.id === id);
    
    if (index !== -1) {
      this.readingList.splice(index, 1);
      this.saveToLocalStorage();
      return true;
    }
    return false;
  }

  // Obtener estadísticas
  getStats() {
    return {
      total: this.readingList.length,
      byLevel: {
        basic: this.readingList.filter(r => r.nivel === ReadingLevel.BASIC).length,
        intermediate: this.readingList.filter(r => r.nivel === ReadingLevel.INTERMEDIATE).length,
        advanced: this.readingList.filter(r => r.nivel === ReadingLevel.ADVANCED).length,
        expert: this.readingList.filter(r => r.nivel === ReadingLevel.EXPERT).length
      },
      genres: [...new Set(this.readingList.map(r => r.genero))]
    };
  }
}
