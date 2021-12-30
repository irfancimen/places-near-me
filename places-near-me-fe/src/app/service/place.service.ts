import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { from, Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { PNMConstants } from "../model/pnm.constant";

@Injectable({
    providedIn: 'root'
})
export class PlaceService {

    private url: string = environment.baseUrl;

    constructor(private httpClient: HttpClient) { }

    getNearbyPlaces(par: any): Observable<any> {
        let params = new HttpParams();
        params = params.append('lat', par.lat);
        params = params.append('lng', par.lng);
        params = params.append('radius', par.radius);
        return from(this.httpClient.get(this.url + PNMConstants.URL_PREFIX + '/places', {params: params}));
    }

}