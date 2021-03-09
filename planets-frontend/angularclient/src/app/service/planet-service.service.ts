import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Planet } from '../model/planet';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PlanetService {

  private planetsUrl: string;

  constructor(private http: HttpClient) {
    this.planetsUrl = 'http://localhost:8080/planets';
  }

  public findAll(): Observable<Planet[]> {
    return this.http.get<Planet[]>(this.planetsUrl + '/getAll');
  }

  public save(planet: Planet) {
    return this.http.post<Planet>(this.planetsUrl + '/createPlanet', planet);
  }

  public postFile(id: number, fileToUpload: File): Observable<any> {
    // const endpoint = 'your-destination-url';
     const formData: FormData = new FormData();
     formData.append('fileKey', fileToUpload, fileToUpload.name);
         return this.http.post<FormData>(this.planetsUrl + '/upload/' + id)

    // return this.httpClient
    //   .post(endpoint, formData, { headers: yourHeadersConfig })
    //   .map(() => { return true; })
    //   .catch((e) => this.handleError(e));
}

}
