import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiseaseSelectComponent } from './disease-select.component';

describe('DiseaseSelectComponent', () => {
  let component: DiseaseSelectComponent;
  let fixture: ComponentFixture<DiseaseSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiseaseSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiseaseSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
