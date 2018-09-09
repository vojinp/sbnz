import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReasonerPageComponent } from './reasoner-page.component';

describe('ReasonerPageComponent', () => {
  let component: ReasonerPageComponent;
  let fixture: ComponentFixture<ReasonerPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReasonerPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReasonerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
