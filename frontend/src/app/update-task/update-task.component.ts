import { Component } from '@angular/core';
import { Task } from '../models/Task';
import { Owner } from '../models/Owner';
import { TaskService } from '../service/task.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OwnerService } from '../service/owner.service';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-update-task',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule, HttpClientModule],
  templateUrl: './update-task.component.html',
  styleUrl: './update-task.component.css',
})
export class UpdateTaskComponent {
  task = new Task();
  inputTask = new Task();
  inputDate = '';
  owners: Owner[] = [];
  ownerId: number | null = null;

  constructor(
    private taskService: TaskService,
    private ownerService: OwnerService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
  }

  updateTask(): void {
    this.ownerService.getOwner(`${this.ownerId}`).subscribe({
      next: (data) => {
        this.task.owner = data;

        this.taskService.putTask(this.task).subscribe(() => {
          alert('Tarefa Alterada com sucesso!');
          this.router.navigate(['/']);
        });
      },
    });
  }

  cancel(): void {
    this.task = new Task();
    this.router.navigate(['/']);
  }

  ngOnInit(): void {
    this.ownerService.getOwners().subscribe((data) => (this.owners = data));

    const currentTaskId = this.activatedRoute.snapshot.paramMap.get('id');
    if (currentTaskId) {
      this.taskService.getTask(currentTaskId).subscribe((data) => {
        this.task = data;
        this.ownerId = this.task.owner ? this.task.owner.id : 1;
      });
    }
  }
}
