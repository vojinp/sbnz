import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicationManagerComponent } from './medication-manager.component';

describe('MedicationManagerComponent', () => {
  let component: MedicationManagerComponent;
  let fixture: ComponentFixture<MedicationManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicationManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicationManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
