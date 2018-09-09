import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from '../../shared/authentication.service';

@Component({
  selector: 'app-ingredient-table',
  templateUrl: './ingredient-table.component.html',
  styleUrls: ['./ingredient-table.component.css']
})
export class IngredientTableComponent implements OnInit {
  @Input() ingredients;
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();
  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
  }


}
