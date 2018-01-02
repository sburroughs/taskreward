import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    TasksComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
