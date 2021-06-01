import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlojamientoDetalleComponent } from './alojamiento-detalle.component';

describe('AlojamientoDetalleComponent', () => {
  let component: AlojamientoDetalleComponent;
  let fixture: ComponentFixture<AlojamientoDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlojamientoDetalleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlojamientoDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
