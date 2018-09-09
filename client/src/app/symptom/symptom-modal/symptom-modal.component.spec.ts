import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SymptomModalComponent } from './symptom-modal.component';

describe('SymptomModalComponent', () => {
  let component: SymptomModalComponent;
  let fixture: ComponentFixture<SymptomModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SymptomModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SymptomModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
