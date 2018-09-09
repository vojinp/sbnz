import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {
  @Input() users;
  @Output() changeEvent = new EventEmitter();
  @Output() removeEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
