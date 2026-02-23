import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario.model';

@Component({
  selector: 'app-usuario-create',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.css']
})
export class UsuarioCreateComponent {
  usuario: Usuario = {
    nombre: '',
    email: '',
    password: '',
    rol: 'estudiante',
    nivel: 'principiante',
    foto: ''
  };

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  generarAvatar(): void {
    const seed = this.usuario.nombre.replace(/\s+/g, '').toLowerCase() || 'usuario';
    const colors = ['b6e3f4', 'c0aede', 'd1f4d1', 'ffd5dc', 'ffdfbf'];
    const color = colors[Math.floor(Math.random() * colors.length)];
    this.usuario.foto = `https://api.dicebear.com/7.x/avataaars/svg?seed=${seed}&backgroundColor=${color}`;
  }

  onSubmit(): void {
    if (!this.usuario.nombre || !this.usuario.email || !this.usuario.password) {
      alert('Todos los campos son obligatorios');
      return;
    }
    if (!this.usuario.foto) {
      this.generarAvatar();
    }
    this.usuarioService.create(this.usuario);
    alert('Usuario creado correctamente');
    this.router.navigate(['/usuarios']);
  }

  onCancel(): void {
    this.router.navigate(['/usuarios']);
  }
}
