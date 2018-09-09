import { Component, OnInit } from '@angular/core';
import {ReportService} from '../../shared/report.service';

@Component({
  selector: 'app-immune-report',
  templateUrl: './immune-report.component.html',
  styleUrls: ['./immune-report.component.css']
})
export class ImmuneReportComponent implements OnInit {
  patients;
  constructor(
    private reportService: ReportService
  ) { }

  ngOnInit() {
    this.reportService.getAll('/api/patient/immune').subscribe(res => {
      this.patients = res;
    });
  }

}
