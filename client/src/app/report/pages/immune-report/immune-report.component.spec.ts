import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImmuneReportComponent } from './immune-report.component';

describe('ImmuneReportComponent', () => {
  let component: ImmuneReportComponent;
  let fixture: ComponentFixture<ImmuneReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImmuneReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImmuneReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
