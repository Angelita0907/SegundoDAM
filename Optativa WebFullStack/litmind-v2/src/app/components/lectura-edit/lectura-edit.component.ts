import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { LecturaService } from '../../services/lectura.service';
import { Lectura } from '../../models/lectura.model';

@Component({
  selector: 'app-lectura-edit',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './lectura-edit.component.html',
  styleUrls: ['./lectura-edit.component.css']
})
export class LecturaEditComponent implements OnInit {
  lectura: Lectura = { titulo: '', genero: '', nivel: 'principiante', resena: '' };
  lecturaId: string = '';
  notFound: boolean = false;

  constructor(private lecturaService: LecturaService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.lecturaId = this.route.snapshot.params['id'];
    const found = this.lecturaService.getById(this.lecturaId);
    if (found) {
      this.lectura = { ...found };
    } else {
      this.notFound = true;
    }
  }

  onSubmit(): void {
    if (!this.lectura.titulo || !this.lectura.genero || !this.lectura.resena) {
      alert('Todos los campos son obligatorios');
      return;
    }
    const ok = this.lecturaService.update(this.lecturaId, this.lectura);
    if (ok) {
      alert('¡Lectura actualizada!');
      this.router.navigate(['/lecturas']);
    } else {
      alert('Error al actualizar');
    }
  }

  deleteLectura(): void {
    if (confirm('¿Seguro que quieres eliminar esta lectura?')) {
      this.lecturaService.delete(this.lecturaId);
      alert('Lectura eliminada');
      this.router.navigate(['/lecturas']);
    }
  }

  onCancel(): void {
    this.router.navigate(['/lecturas']);
  }
}
