import { TestBed } from '@angular/core/testing';

import { CasasRuralesService } from './casas-rurales.service';

describe('CasasRuralesService', () => {
  let service: CasasRuralesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CasasRuralesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
