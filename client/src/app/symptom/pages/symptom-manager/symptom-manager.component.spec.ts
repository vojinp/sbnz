import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SymptomManagerComponent } from './symptom-manager.component';

describe('SymptomManagerComponent', () => {
  let component: SymptomManagerComponent;
  let fixture: ComponentFixture<SymptomManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SymptomManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SymptomManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
