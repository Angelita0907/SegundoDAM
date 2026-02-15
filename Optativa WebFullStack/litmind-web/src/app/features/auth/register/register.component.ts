import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService, RegisterData } from '@core/services/auth.service';
import { UserRole } from '@core/models/user.model';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerData: RegisterData = {
    nombre: '',
    email: '',
    password: '',
    rol: UserRole.STUDENT
  };

  confirmPassword = '';
  loading = signal(false);
  error = signal<string | null>(null);
  showPassword = signal(false);
  showConfirmPassword = signal(false);

  readonly roles = [
    { value: UserRole.STUDENT, label: 'Estudiante' },
    { value: UserRole.TEACHER, label: 'Profesor/a' },
    { value: UserRole.PARENT, label: 'Padre/Madre' }
  ];

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  onSubmit(): void {
    // Validaciones
    if (!this.registerData.nombre || !this.registerData.email || !this.registerData.password) {
      this.error.set('Por favor, completa todos los campos');
      return;
    }

    if (this.registerData.password.length < 6) {
      this.error.set('La contraseña debe tener al menos 6 caracteres');
      return;
    }

    if (this.registerData.password !== this.confirmPassword) {
      this.error.set('Las contraseñas no coinciden');
      return;
    }

    this.loading.set(true);
    this.error.set(null);

    this.authService.register(this.registerData).subscribe({
      next: () => {
        this.router.navigate(['/dashboard']);
      },
      error: (err) => {
        this.error.set(err.message || 'Error al registrarse');
        this.loading.set(false);
      },
      complete: () => {
        this.loading.set(false);
      }
    });
  }

  togglePasswordVisibility(field: 'password' | 'confirm'): void {
    if (field === 'password') {
      this.showPassword.update(v => !v);
    } else {
      this.showConfirmPassword.update(v => !v);
    }
  }
}
