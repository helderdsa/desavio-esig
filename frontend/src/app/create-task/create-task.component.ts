import { NgFor, NgIf } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Task } from '../models/Task';
import { Owner } from '../models/Owner';
import { TaskService } from '../service/task.service';
import { OwnerService } from '../service/owner.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-task',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule, HttpClientModule],
  templateUrl: './create-task.component.html',
  styleUrl: './create-task.component.css',
})
export class CreateTaskComponent {
  task: Task = new Task();
  owner: Owner = new Owner();
  owners: Owner[] = [];
  ownerId: String = '1';

  constructor(
    private taskService: TaskService,
    private ownerService: OwnerService,
    private router: Router
  ) {}

  createTask(): void {
    this.ownerService.getOwner(this.ownerId).subscribe({
      next: (data) => {
        this.owner = data;
        this.task.owner = this.owner;

        this.taskService.postTask(this.task).subscribe(() => {
          alert('Tarefa Cadastrada com sucesso!');
          this.router.navigate(['/']);
        });
      },
    });
  }

  cancel(): void {
    this.task = new Task();
    this.router.navigate(['/']);
  }

  ngOnInit() {
    this.ownerService.getOwners().subscribe((data) => (this.owners = data));
  }
}
