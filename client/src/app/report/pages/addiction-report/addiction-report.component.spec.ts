import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddictionReportComponent } from './addiction-report.component';

describe('AddictionReportComponent', () => {
  let component: AddictionReportComponent;
  let fixture: ComponentFixture<AddictionReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddictionReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddictionReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
