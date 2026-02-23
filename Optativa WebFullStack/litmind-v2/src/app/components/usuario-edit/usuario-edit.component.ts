import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { UsuarioService } from '../../services/usuario.service';
import { Usuario } from '../../models/usuario.model';

@Component({
  selector: 'app-usuario-edit',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './usuario-edit.component.html',
  styleUrls: ['./usuario-edit.component.css']
})
export class UsuarioEditComponent implements OnInit {
  usuario: Usuario = { nombre: '', email: '', password: '', rol: 'estudiante', nivel: 'principiante', foto: '' };
  usuarioId: string = '';
  notFound: boolean = false;

  constructor(private usuarioService: UsuarioService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.usuarioId = this.route.snapshot.params['id'];
    const found = this.usuarioService.getById(this.usuarioId);
    if (found) {
      this.usuario = { ...found };
    } else {
      this.notFound = true;
    }
  }

  onSubmit(): void {
    if (!this.usuario.nombre || !this.usuario.email || !this.usuario.password) {
      alert('Todos los campos son obligatorios');
      return;
    }
    const ok = this.usuarioService.update(this.usuarioId, this.usuario);
    if (ok) {
      alert('Usuario actualizado correctamente');
      this.router.navigate(['/usuarios']);
    } else {
      alert('Error al actualizar');
    }
  }

  deleteUsuario(): void {
    if (confirm('Seguro que quieres eliminar este usuario?')) {
      this.usuarioService.delete(this.usuarioId);
      alert('Usuario eliminado');
      this.router.navigate(['/usuarios']);
    }
  }

  onCancel(): void {
    this.router.navigate(['/usuarios']);
  }
}
