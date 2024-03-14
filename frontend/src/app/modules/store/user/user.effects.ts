import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, debounceTime, map, switchMap } from 'rxjs/operators';
import { of } from 'rxjs';
import * as UserActions from './user.actions';
import { AuthService } from '../../shared/services/auth.service';

@Injectable()
export class UserEffects {
  constructor(
    private actions$: Actions,
    private authService: AuthService,
  ) {}
  login$ = createEffect(() =>
    this.actions$.pipe(
      ofType(UserActions.login),
      debounceTime(300),
      switchMap(({username, password}) =>
        this.authService.login({username, password}).pipe(
          map((user) => UserActions.loginSuccess({user})),
          catchError((error) => of(UserActions.loginFailure({ error })))
        )
      )
    )
  );
   
}