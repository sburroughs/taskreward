import {Component, OnInit} from '@angular/core';
import {TasksService} from '../shared/tasks.service';
import {NgForm} from '@angular/forms';
import {Task} from '../model/task.model';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css'],
  providers: [TasksService]
})
export class TasksComponent implements OnInit {

  completedPoints: number;
  tasks: Array<Task>;

  constructor(private tasksService: TasksService) {
    this.completedPoints = 0;
  }

  ngOnInit() {
    this.update();
    this.getCompletedPoints();
  }

  create(taskForm: NgForm) {
    // TODO: convert to model
    const task: Task = new Task(null,
      taskForm.value.name,
      taskForm.value.reward,
      'CREATED');

    console.log(task);
    this.tasksService.create(task).subscribe(
      data => {
        taskForm.reset();
        this.update();
      },
      error => console.log(error)
    );

  }

  update() {
    console.log('update');

    this.tasksService.getAll().subscribe(
      data => {
        this.tasks = data;
        this.getCompletedPoints();
      },
      error => console.log(error)
    );
  }

  completeTask(id: number) {

    const status = 'COMPLETED';
    console.log('completeTask');

    this.tasksService.updateStatus(id, status).subscribe(
      data => {
        console.log(data);
        this.update();
      },
      error => console.log(error)
    );
  }


  getCompletedPoints() {
    console.log('getCompletedPoints');

    this.tasksService.getCompletedPoints().subscribe(
      data => {
        this.completedPoints = data;
      },
      error => console.log(error)
    );
  }
}
