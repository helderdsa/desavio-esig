import { Owner } from './Owner';

export class Task {
  id!: number;
  title!: string;
  status: string = 'Pendente';
  description!: string;
  priority: string = 'LOW';
  deadline!: string;
  owner!: Owner;
}
