import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleVjComponent } from './detalle-vj.component';

describe('DetalleVjComponent', () => {
  let component: DetalleVjComponent;
  let fixture: ComponentFixture<DetalleVjComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalleVjComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleVjComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
