import { Owner } from './Owner';

export class Task {
  id!: number;
  title!: string;
  status: string = 'ON_GOING';
  description!: string;
  priority: string = 'LOW';
  deadline!: string;
  owner!: Owner;
}
