import { TestBed, inject } from '@angular/core/testing';

import { PlanetServiceService } from './planet-service.service';

describe('PlanetServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PlanetServiceService]
    });
  });

  it('should be created', inject([PlanetServiceService], (service: PlanetServiceService) => {
    expect(service).toBeTruthy();
  }));
});
