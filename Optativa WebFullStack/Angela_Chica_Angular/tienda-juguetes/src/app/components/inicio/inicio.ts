import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { JugueteService } from '../../services/juguetes';
import { Juguete } from '../../models/juguete.model';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './inicio.html',
  styleUrls: ['./inicio.css']
})
export class Inicio implements OnInit {
  juguetes: Juguete[] = [];

  constructor(private jugueteService: JugueteService) {}

  ngOnInit(): void {
    this.juguetes = this.jugueteService.getDisponibles();
  }
}