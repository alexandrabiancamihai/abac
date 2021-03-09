import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PlanetFormComponent } from './planet-form/planet-form.component';
import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PlanetService } from './service/planet-service.service';


@NgModule({
  declarations: [
    AppComponent,
    PlanetListComponent,
    PlanetFormComponent
  ],
  imports: [
   BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PlanetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
