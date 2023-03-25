import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {RegisterRequest} from "../models/auth/register-request.model";
import {Observable} from "rxjs";
import {AuthenticationResponse} from "../models/auth/authentication-response.model";
import {AuthenticationRequest} from "../models/auth/authentication-request.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private restPath: string = environment.apisBaseUrl + "/api/authenticate";
  constructor(private http: HttpClient) {}

  public  register(request: RegisterRequest): Observable< AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.restPath}/register`,request);
}
  public  authenticate(request: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.restPath}/login`, request);
}

}
