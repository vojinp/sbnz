import {Component, Input, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-ingredient-modal',
  templateUrl: './ingredient-modal.component.html',
  styleUrls: ['./ingredient-modal.component.css']
})
export class IngredientModalComponent implements OnInit {
  @Input() ingredient;

  constructor(public activeModal: NgbActiveModal) {
  }

  ngOnInit() {
  }

}
