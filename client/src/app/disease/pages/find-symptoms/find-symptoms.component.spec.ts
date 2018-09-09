import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindSymptomsComponent } from './find-symptoms.component';

describe('FindSymptomsComponent', () => {
  let component: FindSymptomsComponent;
  let fixture: ComponentFixture<FindSymptomsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindSymptomsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindSymptomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
