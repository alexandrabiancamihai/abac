import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PlanetService } from '../service/planet-service.service';
import { Planet } from '../model/planet';
import { Crew } from '../model/crew';

@Component({
  selector: 'app-planet-form',
  templateUrl: './planet-form.component.html',
  styleUrls: ['./planet-form.component.css']
})
export class PlanetFormComponent  {

  fileToUpload: File = null;

	planet: Planet;

  

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private planetService: PlanetService) {
    this.planet = new Planet();
    this.planet.crew = new Crew();
     this.planet.crew.robots = [];
     this.planet.image=ArrayBuffer;
     this.robot = [];
  }

  onSubmit() {
    console.log(this.planet);
    this.planet.crew.robots.push(this.robot);
    this.planetService.save(this.planet).subscribe(result => this.gotoPlanetList());
  }

  gotoPlanetList() {
    this.router.navigate(['/planets']);
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
}

uploadFileToActivity() {
    this.planetService.postFile(this.planet.id, this.fileToUpload).subscribe(data => {
      }, error => {
        console.log(error);
      });
  }

}
