import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoVJComponent } from './listado-vj.component';

describe('ListadoVJComponent', () => {
  let component: ListadoVJComponent;
  let fixture: ComponentFixture<ListadoVJComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoVJComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoVJComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
