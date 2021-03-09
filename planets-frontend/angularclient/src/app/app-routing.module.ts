import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PlanetListComponent } from './planet-list/planet-list.component';
import { PlanetFormComponent } from './planet-form/planet-form.component';

const routes: Routes = [
  { path: 'planets', component: PlanetListComponent },
  { path: 'addplanet', component: PlanetFormComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
