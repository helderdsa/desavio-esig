import { Owner } from './Owner';

export class Task {
  id: number = 2;
  title: String = '';
  status: String = '';
  description: String = '';
  priority: String = '';
  deadline: Date = new Date();
  owner: Owner = new Owner();
}
