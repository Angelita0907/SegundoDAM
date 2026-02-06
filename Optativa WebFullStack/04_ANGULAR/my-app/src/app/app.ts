/* comento esto para empezar con el tutorial de angular de cero*/

import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Pokemon } from './components/pokemon/pokemon';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Pokemon],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('my-app');
}

 /*
import {Component} from '@angular/core';

@Component({
  selector: 'app-user',
  template: ` Nombre de Usuario: {{ username }} `,
})
export class User {
  username = 'Aishla';
}

@Component({
  selector: 'app-root',
  template: `<app-user />`,
  imports: [User]
})
export class App {}
*/

// usando el componente @if
/*
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: ` 
    @if (isServerRunning){
    <span>Yes, the server is running</span>
    }
    @else{
      <p>No, the server is not running</p>
      }
  `,
})
export class App {
  isServerRunning = true;
}
*/

// usando el componente for
/*
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: `@for (user of users; track user.id) {
    <p>{{ user.name }}</p>
  }`,
})
export class App {
  operatingSystems = [
    {id: 'win', name: 'Windows'}, 
    {id: 'osx', name: 'MacOS'}, 
    {id: 'linux', name: 'Linux'}
  ];

  users = [
    {id: 0, name: 'Sarah'},
    {id: 1, name: 'Amy'},
    {id: 2, name: 'Rachel'},
    {id: 3, name: 'Jessica'},
    {id: 4, name: 'Poornima'},
  ];

}
  */

// Property Binding in Angular
// basicamente usar html en angular
/*
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  styleUrls: ['app.css'],
    template: `<div [contentEditable]="isEditable"></div>`,

})
export class App {
  isEditable = true;
}
*/

//Event handling --> para interactuar con elementos de la web
/*
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <section (mouseover)="showSecretMessage()">
      There's a secret message for you, hover to reveal 👀
      {{ message }}
    </section>
  `,
})
export class App {
  // lo muestra cada vez que se la da al botón
  greet() {
    console.log('Hello, there 👋');
  }

  message = '';
  showSecretMessage() {
  this.message = 'Way to go 🚀';
}
}*/
