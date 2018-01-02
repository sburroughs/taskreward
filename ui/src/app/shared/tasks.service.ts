import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Task} from '../model/task.model';

@Injectable()
export class TasksService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('http://localhost:8080/task');
  }

  create(request: Task) {
    return this.http.post('http://localhost:8080/task', request);
  }

  getCompletedPoints(): Observable<any> {
    return this.http.get('http://localhost:8080/task/count',
      {
        params: {'status': 'COMPLETED'}
      });
  }

  updateStatus(id: number, status: string) {
    console.log(status);

    return this.http.put('http://localhost:8080/task/' + id + '/status',
      {'status': status});
  }
}
