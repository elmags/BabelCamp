import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfUsComponent } from './inf-us.component';

describe('InfUsComponent', () => {
  let component: InfUsComponent;
  let fixture: ComponentFixture<InfUsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfUsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfUsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
