import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitoringPageComponent } from './monitoring-page.component';

describe('MonitoringPageComponent', () => {
  let component: MonitoringPageComponent;
  let fixture: ComponentFixture<MonitoringPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonitoringPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitoringPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
