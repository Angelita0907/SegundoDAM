import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ReadingManagementService } from '@core/services/reading-management.service';
import { Reading, ReadingLevel } from '@core/models/reading.model';

@Component({
  selector: 'app-readings-list',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './readings-list.component.html',
  styleUrls: ['./readings-list.component.css']
})
export class ReadingsListComponent implements OnInit {
  readingsList = signal<Reading[]>([]);
  filteredReadings = signal<Reading[]>([]);
  searchQuery = signal('');
  selectedLevel = signal<ReadingLevel | 'ALL'>('ALL');
  stats = signal<any>(null);

  readonly ReadingLevel = ReadingLevel;
  readonly levels = [
    { value: 'ALL', label: 'Todos los niveles' },
    { value: ReadingLevel.BASIC, label: 'Básico' },
    { value: ReadingLevel.INTERMEDIATE, label: 'Intermedio' },
    { value: ReadingLevel.ADVANCED, label: 'Avanzado' },
    { value: ReadingLevel.EXPERT, label: 'Experto' }
  ];

  constructor(private readingService: ReadingManagementService) { }

  ngOnInit(): void {
    this.loadReadings();
    this.loadStats();
  }

  loadReadings(): void {
    const readings = this.readingService.getAll();
    this.readingsList.set(readings);
    this.applyFilters();
  }

  loadStats(): void {
    this.stats.set(this.readingService.getStats());
  }

  applyFilters(): void {
    let filtered = this.readingsList();

    // Filtrar por búsqueda
    const query = this.searchQuery().toLowerCase();
    if (query) {
      filtered = filtered.filter(r => 
        r.titulo.toLowerCase().includes(query) ||
        (r.autor && r.autor.toLowerCase().includes(query)) ||
        r.genero.toLowerCase().includes(query)
      );
    }

    // Filtrar por nivel
    const level = this.selectedLevel();
    if (level !== 'ALL') {
      filtered = filtered.filter(r => r.nivel === level);
    }

    this.filteredReadings.set(filtered);
  }

  onSearchChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.searchQuery.set(input.value);
    this.applyFilters();
  }

  onLevelChange(event: Event): void {
    const select = event.target as HTMLSelectElement;
    this.selectedLevel.set(select.value as ReadingLevel | 'ALL');
    this.applyFilters();
  }

  deleteReading(id: string): void {
    if (confirm('¿Estás seguro de que quieres eliminar esta lectura?')) {
      const success = this.readingService.delete(id);
      if (success) {
        this.loadReadings();
        this.loadStats();
      } else {
        alert('Error al eliminar la lectura');
      }
    }
  }

  getLevelBadgeClass(level: ReadingLevel): string {
    const classes: Record<ReadingLevel, string> = {
      [ReadingLevel.BASIC]: 'badge-basic',
      [ReadingLevel.INTERMEDIATE]: 'badge-intermediate',
      [ReadingLevel.ADVANCED]: 'badge-advanced',
      [ReadingLevel.EXPERT]: 'badge-expert'
    };
    return classes[level] || '';
  }

  getLevelLabel(level: ReadingLevel): string {
    const labels: Record<ReadingLevel, string> = {
      [ReadingLevel.BASIC]: 'Básico',
      [ReadingLevel.INTERMEDIATE]: 'Intermedio',
      [ReadingLevel.ADVANCED]: 'Avanzado',
      [ReadingLevel.EXPERT]: 'Experto'
    };
    return labels[level] || level;
  }

  formatDuration(minutes: number): string {
    if (minutes < 60) {
      return `${minutes} min`;
    }
    const hours = Math.floor(minutes / 60);
    const mins = minutes % 60;
    return mins > 0 ? `${hours}h ${mins}min` : `${hours}h`;
  }
}
