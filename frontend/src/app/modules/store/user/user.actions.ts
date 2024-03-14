import { createAction, props } from '@ngrx/store';
import { Token } from '../../shared/interfaces/token.model';
import { User, UserInfoWrapper } from '../../shared/interfaces/user.model';

export const login = createAction(
  '[User] Login',
  props<{ username: string; password: string }>()
);
export const loginSuccess = createAction(
  '[User] Login Success',
  props<{ user: UserInfoWrapper }>()
);
export const loginFailure = createAction(
  '[User] Login Failure',
  props<{ error: string }>()
);

export const logout = createAction('[User] Logout');
