import { Crew } from '../model/crew';


export class Planet {
 	id: number;
    name: string;
    image: ArrayBuffer;
    status: string;
    crew: Crew;
}