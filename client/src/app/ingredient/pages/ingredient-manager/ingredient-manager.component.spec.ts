import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientManagerComponent } from './ingredient-manager.component';

describe('IngredientManagerComponent', () => {
  let component: IngredientManagerComponent;
  let fixture: ComponentFixture<IngredientManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
