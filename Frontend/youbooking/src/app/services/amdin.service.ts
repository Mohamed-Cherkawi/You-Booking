import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Hotel} from "../models/hotel.model";

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private restPath: string = environment.apisBaseUrl + '/api/admin';
  constructor(private http: HttpClient) { }


  public getAllCreatedHotelsApi(): Observable<Hotel[] | null> {
    return this.http.get<Hotel[] | null>(`${this.restPath}/fetching-all-hotels`);
  }
  //@GetMapping("/fetching/track-id/{hotelId}")
  public getCreatedHotelByOwnerByIdApi(hotelId: number): Observable<Hotel | string>{
    return this.http.get<Hotel | string>(`${environment.apisBaseUrl}/api/hotel/manager/fetching/track-id/${hotelId}`);
}

}
