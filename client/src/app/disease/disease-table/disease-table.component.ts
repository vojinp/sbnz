import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-disease-table',
  templateUrl: './disease-table.component.html',
  styleUrls: ['./disease-table.component.css']
})
export class DiseaseTableComponent implements OnInit {
  @Input() diseases;
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

}
