import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartReasonerComponent } from './start-reasoner.component';

describe('StartReasonerComponent', () => {
  let component: StartReasonerComponent;
  let fixture: ComponentFixture<StartReasonerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartReasonerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartReasonerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
