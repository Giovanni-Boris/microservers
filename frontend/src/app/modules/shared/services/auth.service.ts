import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { Global } from '../constants/global';
import { Token } from '../interfaces/token.model';
import { UserUpload } from '../interfaces/userUpload';
import { UserInfoWrapper } from '../interfaces/user.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(data: {
    username: string;
    password: string;
  }): Observable<UserInfoWrapper> {
    return this.http
      .post< UserInfoWrapper>(Global.API_URL + 'v1/auth/authenticate', { data })
      .pipe(catchError(this.handleError));
  }
  register(registerCredentials: UserUpload): Observable<string> {
    console.log(registerCredentials)
    return this.http
      .post(
        Global.API_URL + 'Auth/register',
        { ...registerCredentials },
        { responseType: 'text' }
      )
      .pipe(catchError(this.handleError));
  }

  private handleError(err: HttpErrorResponse): Observable<never> {
    return throwError(() => err);
  }
}
