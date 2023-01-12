import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hotel} from "../models/hotel.model";
import {HotelOffer} from "../models/hotel-offer.model";
import {StatusMapper} from "../utils/status-mapper.util";
import {AvailabilityStateEnum} from "../enums/availability-state.enum";
import {AcceptanceStateEnum} from "../enums/acceptance-state.enum";
import {IdClassMapper} from "../utils/id-class-mapper.util";

@Injectable({
  providedIn: 'root'
})
export class HotelOwnerService {
  private apiServerUrl: string = environment.apisBaseUrl + "/api/hotel/manager";

  constructor(private http: HttpClient) {
  }

  public getCreatedHotelByOwnerByIdApi(hotelId: number): Observable<Hotel | string> {
    return this.http.get<Hotel | string>(`${this.apiServerUrl}/fetching/track-id/${hotelId}`);
  }

  public getCreatedHotelOfferByOwnerByIdApi(offerId: number): Observable<HotelOffer | string> {
    return this.http.get<HotelOffer | string>(`${this.apiServerUrl}/fetching/track-offer-id/${offerId}`)
}
  public getAllCreatedHotelsByOwnerApi(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>(`${this.apiServerUrl}/fetching-all`);
  }
  public getAllCreatedHotelOffersByOwnerApi(): Observable<HotelOffer[]> {
    return this.http.get<HotelOffer[]>(`${this.apiServerUrl}/fetching-all-offers`);
  }
  public addHotelCreatedByOwnerApi(hotel: Hotel): Observable<Hotel> {
    return this.http.post<Hotel>(`${this.apiServerUrl}/adding-new`,hotel);
  }
  public addHotelOfferCreatedByOwnerApi(hotelOffer: HotelOffer): Observable<HotelOffer> {
    return this.http.post<HotelOffer>(`${this.apiServerUrl}/adding-new-request-offer`,hotelOffer);
  }
  public updateHotelCreatedByOwnerIdApi(hotel: Hotel): Observable<Hotel> {
    return this.http.put<Hotel>(`${this.apiServerUrl}/updating`,hotel);
  }
  public updateBedRoomAvailabilityStatusApi(statusMapper: StatusMapper<AvailabilityStateEnum>): Observable<StatusMapper<AvailabilityStateEnum> | string> {
    return this.http.patch<StatusMapper<AvailabilityStateEnum> | string>(`${this.apiServerUrl}/updating-bed-room-status`,statusMapper);
  }
  public updateReservationAcceptanceStatusApi(statusMapper: StatusMapper<AcceptanceStateEnum>): Observable<StatusMapper<AcceptanceStateEnum> | string> {
    return this.http.patch<StatusMapper<AcceptanceStateEnum> | string>(`${this.apiServerUrl}/updating-reservation-status`,statusMapper);
  }
  public deleteHotelCreatedByOwnerApi(idClassMapper: IdClassMapper): Observable<string> {
  return this.http.request<string>('DELETE', `${this.apiServerUrl}/deleting`,{ body: idClassMapper });
  }
  public deleteHotelOfferCreatedByOwnerApi(idClassMapper: IdClassMapper): Observable<string> {
    return this.http.request<string>('DELETE', `${this.apiServerUrl}/deleting-offer`,{ body: idClassMapper });
  }
}
