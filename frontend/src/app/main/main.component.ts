import { NgClass, NgFor, NgIf } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Task } from '../models/Task';
import { TaskService } from '../service/task.service';
import { Router } from '@angular/router';
import { Owner } from '../models/Owner';
import { OwnerService } from '../service/owner.service';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [NgIf, NgFor, NgClass, FormsModule, HttpClientModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css',
})
export class MainComponent {
  searchTask = {
    title: '',
    status: '',
    deadline: '',
    description: '',
    owner: '',
    priority: '',
  };
  owners: Owner[] = [];
  tasks: Task[] = [];

  constructor(
    private taskService: TaskService,
    private ownerService: OwnerService,
    private router: Router
  ) {}

  goTo(route: String): void {
    this.router.navigate([route]);
  }

  colorSelect(condition: string): string {
    if (condition == "Baixa") return "table-success"
    if (condition == "Média") return "table-warning"
    return "table-danger"
  }

  reorganizeDate(date: string): string {
    if (date) {
      const [y, m, d] = date.split('-');
      return `${ d + "/" + m + "/" + y }`
    }
    return ""
  }

  searchTasks(): void {
    const { title, status, deadline, description, owner, priority } =
      this.searchTask;
    this.taskService
      .searchTasks(title, status, description, priority, deadline, owner)
      .subscribe((data) => (this.tasks = data));
  }

  deleteTask(id: number): void {
    this.taskService.deleteTask(id.toString()).subscribe(() => {
      alert('Tarefa deletada com sucesso!');
      this.taskService.getTasks().subscribe((data) => (this.tasks = data));
    });
  }

  completeTask(id: number): void {
    var currentTask = new Task()
    this.taskService.getTask(id.toString()).subscribe((data) => {
      currentTask = data
      currentTask.status = "Feito"

      this.taskService.putTask(currentTask).subscribe();
      alert('Tarefa Concluída com sucesso!');
      this.taskService.getTasks().subscribe((data) => (this.tasks = data));
    });
    
  }

  ngOnInit() {
    this.taskService.getTasks().subscribe((data) => (this.tasks = data));
    this.ownerService.getOwners().subscribe((data) => (this.owners = data));
  }
}
