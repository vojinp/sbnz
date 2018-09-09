import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiseaseManagerComponent } from './disease-manager.component';

describe('DiseaseManagerComponent', () => {
  let component: DiseaseManagerComponent;
  let fixture: ComponentFixture<DiseaseManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiseaseManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiseaseManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
