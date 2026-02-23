import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario.model';

@Component({
  selector: 'app-usuario-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {
  usuarios: Usuario[] = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.loadUsuarios();
  }

  loadUsuarios(): void {
    this.usuarios = this.usuarioService.getAll();
  }

  deleteUsuario(id: string | undefined): void {
    if (!id) return;
    if (confirm('Estas seguro de que quieres eliminar este usuario?')) {
      const ok = this.usuarioService.delete(id);
      if (ok) {
        alert('Usuario eliminado correctamente');
        this.loadUsuarios();
      }
    }
  }

  getRolClass(rol: string): string {
    return 'rol-' + rol;
  }

  getRolLabel(rol: string): string {
    const labels: Record<string, string> = {
      admin: 'Admin', estudiante: 'Estudiante',
      profesor: 'Profesor', padre: 'Padre/Madre'
    };
    return labels[rol] || rol;
  }

  getNivelClass(nivel: string): string {
    if (nivel === 'principiante') return 'nivel-p';
    if (nivel === 'intermedio') return 'nivel-i';
    return 'nivel-a';
  }
}
