import { Routes } from '@angular/router';
import { MainComponent } from './main/main.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { UpdateTaskComponent } from './update-task/update-task.component';

export const routes: Routes = [
  {path: '', component: MainComponent, title: "home"},
  {path: 'cadastro', component: CreateTaskComponent, title: "cadastrar"},
  {path: 'alterar/:id', component: UpdateTaskComponent, title: "alterar"}
];
