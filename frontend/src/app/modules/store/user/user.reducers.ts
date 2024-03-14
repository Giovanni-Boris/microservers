import { createReducer, on } from '@ngrx/store';
import {
  login,
  loginSuccess,
  loginFailure,
  logout,
} from './user.actions';
import { initialState } from './user.state';


export const userReducer = createReducer(
  initialState,
  on(login, (state) => ({ ...state, isFetching: true })),
  on(loginSuccess, (state, { user }) => ({
    ...state,
    isFetching: false,
    error: null,
    user: user.data,
  })),
  on(loginFailure, (state, { error }) => ({
    ...state,
    error,
    isFetching: false
  })),
  on(logout, () => initialState)
);