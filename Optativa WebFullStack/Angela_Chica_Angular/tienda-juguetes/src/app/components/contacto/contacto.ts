import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contacto',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contacto.html',
  styleUrls: ['./contacto.css']
})
export class Contacto {
  nombre = '';
  email = '';
  mensaje = '';
  enviado = false;
  error = false;

  // un formualrio simple de contacto para darle creatividad ;)
  enviar(): void {
    if (!this.nombre || !this.email || !this.mensaje) {
      this.error = true;
      return;
    }
    this.error = false;
    this.enviado = true;
    this.nombre = '';
    this.email = '';
    this.mensaje = '';
  }
}