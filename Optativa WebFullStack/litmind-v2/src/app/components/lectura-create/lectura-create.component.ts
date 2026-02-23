import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { LecturaService } from '../../services/lectura.service';
import { Lectura } from '../../models/lectura.model';

@Component({
  selector: 'app-lectura-create',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './lectura-create.component.html',
  styleUrls: ['./lectura-create.component.css']
})
export class LecturaCreateComponent {
  lectura: Lectura = {
    titulo: '',
    genero: '',
    nivel: 'principiante',
    resena: ''
  };

  constructor(private lecturaService: LecturaService, private router: Router) {}

  onSubmit(): void {
    if (!this.lectura.titulo || !this.lectura.genero || !this.lectura.resena) {
      alert('Todos los campos son obligatorios');
      return;
    }
    this.lecturaService.create(this.lectura);
    alert('¡Lectura creada correctamente!');
    this.router.navigate(['/lecturas']);
  }

  onCancel(): void {
    this.router.navigate(['/lecturas']);
  }
}
