import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChronicReportComponent } from './chronic-report.component';

describe('ChronicReportComponent', () => {
  let component: ChronicReportComponent;
  let fixture: ComponentFixture<ChronicReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChronicReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChronicReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
