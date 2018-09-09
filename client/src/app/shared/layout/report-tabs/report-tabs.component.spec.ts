import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportTabsComponent } from './report-tabs.component';

describe('ReportTabsComponent', () => {
  let component: ReportTabsComponent;
  let fixture: ComponentFixture<ReportTabsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportTabsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
