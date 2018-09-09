import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-disease-select',
  templateUrl: './disease-select.component.html',
  styleUrls: ['./disease-select.component.css']
})
export class DiseaseSelectComponent implements OnInit {
  @Input() diseases;
  @Output() diseaseEvent = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

}
