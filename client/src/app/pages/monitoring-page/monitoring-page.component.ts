import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Stomp} from 'stompjs/lib/stomp.js';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-monitoring-page',
  templateUrl: './monitoring-page.component.html',
  styleUrls: ['./monitoring-page.component.css']
})
export class MonitoringPageComponent implements OnInit {
  private serverUrl = 'http://localhost:8080/socket';
  private title = 'WebSockets chat';
  private stompClient;
  mess = '';
  constructor(
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.http.get('/api/diagnosis/simulation').subscribe();
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    this.stompClient['that'] = this;
    const that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/chat', (message) => {
        if (message.body) {
          this.that.mess = message.body;
        }
      });
    });
  }

  changeMessage(message) {
    this.mess = message;
  }



}
