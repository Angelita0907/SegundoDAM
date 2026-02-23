import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { ActividadService } from '../../services/actividad.service';
import { Usuario } from '../../models/usuario.model';
import { Actividad } from '../../models/lectura.model';

@Component({
  selector: 'app-mi-perfil',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './mi-perfil.component.html',
  styleUrls: ['./mi-perfil.component.css']
})
export class MiPerfilComponent implements OnInit {
  usuario: Usuario | null = null;
  actividades: Actividad[] = [];
  actividadesCompletadas: number = 0;
  puntuacionMedia: number = 0;

  constructor(
    private authService: AuthService,
    private actividadService: ActividadService
  ) {}

  ngOnInit(): void {
    this.usuario = this.authService.getUsuarioActual();
    if (this.usuario?._id) {
      this.actividades = this.actividadService.getByUsuario(this.usuario._id);
      this.actividadesCompletadas = this.actividades.filter(a => a.completada).length;
      const completadas = this.actividades.filter(a => a.completada);
      if (completadas.length > 0) {
        this.puntuacionMedia = Math.round(
          completadas.reduce((sum, a) => sum + a.puntuacion, 0) / completadas.length
        );
      }
    }
  }

  getNivelClass(nivel: string): string {
    if (nivel === 'principiante') return 'nivel-p';
    if (nivel === 'intermedio') return 'nivel-i';
    return 'nivel-a';
  }

  getRolLabel(rol: string): string {
    const labels: Record<string, string> = {
      admin: 'Administrador',
      estudiante: 'Estudiante',
      profesor: 'Profesor',
      padre: 'Padre / Madre'
    };
    return labels[rol] || rol;
  }
}
