import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JugueteService } from '../../services/juguetes';
import { Juguete } from '../../models/juguete.model';

@Component({
  selector: 'app-catalogo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './catalogo.html',
  styleUrls: ['./catalogo.css']
})
export class Catalogo implements OnInit {
  juguetes: Juguete[] = [];

  constructor(private jugueteService: JugueteService) {}

  // lo mismo que con el incio pero muestra todos los juguetes
  ngOnInit(): void {
    this.juguetes = this.jugueteService.getAll();
  }
}