import { Component, OnInit } from '@angular/core';
import {ReportService} from '../../shared/report.service';

@Component({
  selector: 'app-addiction-report',
  templateUrl: './addiction-report.component.html',
  styleUrls: ['./addiction-report.component.css']
})
export class AddictionReportComponent implements OnInit {
  patients;
  constructor(
    private reportService: ReportService
  ) { }

  ngOnInit() {
    this.reportService.getAll('/api/patient/addict').subscribe(res => {
      this.patients = res;
    });
  }

}
