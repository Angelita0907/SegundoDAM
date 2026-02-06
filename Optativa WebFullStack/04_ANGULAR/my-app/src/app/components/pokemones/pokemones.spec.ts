import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pokemones } from './pokemones';

describe('Pokemones', () => {
  let component: Pokemones;
  let fixture: ComponentFixture<Pokemones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pokemones]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pokemones);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
