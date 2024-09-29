import { NgFor, NgIf } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Task } from '../models/Task';
import { TaskService } from '../service/task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule, HttpClientModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  task = new Task
  tasks: Task[] = []

  constructor(private service: TaskService, private router: Router) {}

  list(): void {
    this.service.getTasks().subscribe((data) => (this.tasks = data))
  }

  ngOnInit() {
    this.list();
  }
}
