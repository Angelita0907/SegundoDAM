import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ReadingManagementService } from '@core/services/reading-management.service';
import { Reading, ReadingLevel } from '@core/models/reading.model';

@Component({
  selector: 'app-reading-edit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reading-edit.component.html',
  styleUrls: ['./reading-edit.component.css']
})
export class ReadingEditComponent implements OnInit {
  reading = signal<Reading | null>(null);
  readingId = signal<string>('');
  
  readonly ReadingLevel = ReadingLevel;
  readonly levels = [
    { value: ReadingLevel.BASIC, label: 'Básico', description: 'Para lectores principiantes' },
    { value: ReadingLevel.INTERMEDIATE, label: 'Intermedio', description: 'Nivel estándar de lectura' },
    { value: ReadingLevel.ADVANCED, label: 'Avanzado', description: 'Para lectores experimentados' },
    { value: ReadingLevel.EXPERT, label: 'Experto', description: 'Nivel superior de comprensión' }
  ];

  errors = signal<string[]>([]);
  saving = signal(false);
  loading = signal(true);
  notFound = signal(false);

  constructor(
    private readingService: ReadingManagementService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.readingId.set(id);
    this.loadReading(id);
  }

  loadReading(id: string): void {
    const foundReading = this.readingService.getById(id);
    
    if (foundReading) {
      this.reading.set(foundReading);
      this.loading.set(false);
    } else {
      this.notFound.set(true);
      this.loading.set(false);
    }
  }

  updateField(field: keyof Reading, value: any): void {
    const current = this.reading();
    if (current) {
      this.reading.set({ ...current, [field]: value });
    }
  }

  validateForm(): boolean {
    const errors: string[] = [];
    const r = this.reading();

    if (!r) {
      errors.push('No se encontró la lectura');
      this.errors.set(errors);
      return false;
    }

    if (!r.titulo || r.titulo.trim().length < 3) {
      errors.push('El título debe tener al menos 3 caracteres');
    }

    if (!r.genero || r.genero.trim().length < 3) {
      errors.push('El género debe tener al menos 3 caracteres');
    }

    if (!r.contenido || r.contenido.trim().length < 50) {
      errors.push('El contenido debe tener al menos 50 caracteres');
    }

    if (!r.resena || r.resena.trim().length < 10) {
      errors.push('La resena debe tener al menos 10 caracteres');
    }

    if (!r.duracionEstimada || r.duracionEstimada < 1) {
      errors.push('La duración estimada debe ser mayor a 0');
    }

    this.errors.set(errors);
    return errors.length === 0;
  }

  onSubmit(): void {
    if (!this.validateForm()) {
      return;
    }

    const r = this.reading();
    if (!r) return;

    this.saving.set(true);
    
    try {
      const success = this.readingService.update(this.readingId(), r);
      
      if (success) {
        setTimeout(() => {
          this.saving.set(false);
          this.router.navigate(['/admin/readings']);
        }, 500);
      } else {
        this.errors.set(['Error al actualizar la lectura']);
        this.saving.set(false);
      }
    } catch (error) {
      console.error('Error updating reading:', error);
      this.errors.set(['Error al actualizar la lectura. Por favor, intenta de nuevo.']);
      this.saving.set(false);
    }
  }

  onCancel(): void {
    if (confirm('¿Estás seguro de que quieres cancelar? Se perderán los cambios no guardados.')) {
      this.router.navigate(['/admin/readings']);
    }
  }

  generatePlaceholderCover(): void {
    const r = this.reading();
    if (!r) return;

    const title = r.titulo || 'Libro';
    const encodedTitle = encodeURIComponent(title.substring(0, 20));
    const color = this.getColorByLevel(r.nivel);
    const url = `https://via.placeholder.com/150/${color}/FFFFFF?text=${encodedTitle}`;
    this.updateField('portada', url);
  }

  private getColorByLevel(level: ReadingLevel): string {
    const colors: Record<ReadingLevel, string> = {
      [ReadingLevel.BASIC]: '81C784',
      [ReadingLevel.INTERMEDIATE]: 'FDD835',
      [ReadingLevel.ADVANCED]: 'FF7043',
      [ReadingLevel.EXPERT]: 'E91E63'
    };
    return colors[level] || '8575A2';
  }
}
