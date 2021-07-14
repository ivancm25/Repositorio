import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasasRuralesComponent } from './casas-rurales.component';

describe('CasasRuralesComponent', () => {
  let component: CasasRuralesComponent;
  let fixture: ComponentFixture<CasasRuralesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CasasRuralesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CasasRuralesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
