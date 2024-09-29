import { Owner } from './Owner';

export class Task {
  id: number = 0;
  title: String = '';
  status: String = 'ON_GOING';
  description: String = '';
  priority: String = 'LOW';
  deadline: Date = new Date();
  owner: Owner = new Owner();
}
