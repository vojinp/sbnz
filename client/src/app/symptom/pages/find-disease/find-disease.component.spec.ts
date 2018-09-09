import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindDiseaseComponent } from './find-disease.component';

describe('FindDiseaseComponent', () => {
  let component: FindDiseaseComponent;
  let fixture: ComponentFixture<FindDiseaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindDiseaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindDiseaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
