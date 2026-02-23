import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LecturaService } from '../../services/lectura.service';
import { Lectura } from '../../models/lectura.model';

@Component({
  selector: 'app-lectura-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './lectura-list.component.html',
  styleUrls: ['./lectura-list.component.css']
})
export class LecturaListComponent implements OnInit {
  lecturas: Lectura[] = [];

  constructor(private lecturaService: LecturaService) {}

  ngOnInit(): void {
    this.loadLecturas();
  }

  loadLecturas(): void {
    this.lecturas = this.lecturaService.getAll();
  }

  deleteLectura(id: string | undefined): void {
    if (!id) return;
    if (confirm('Estas seguro de que quieres eliminar esta lectura?')) {
      const ok = this.lecturaService.delete(id);
      if (ok) {
        alert('Lectura eliminada correctamente');
        this.loadLecturas();
      }
    }
  }

  getNivelClass(nivel: string): string {
    if (nivel === 'principiante') return 'nivel-p';
    if (nivel === 'intermedio') return 'nivel-i';
    return 'nivel-a';
  }
}
