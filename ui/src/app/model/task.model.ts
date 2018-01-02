export class Task {

  id: number;
  name: string;
  reward: number;
  status: string;

  constructor(id: number, name: string, reward: number, status: string) {
    this.id = id;
    this.name = name;
    this.reward = reward;
    this.status = status;
  }

}
