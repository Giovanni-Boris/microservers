import { Action, ActionReducer, MetaReducer } from "@ngrx/store";
import { UserState } from "./user/user.state";


export function persistStateReducer(_reducer: ActionReducer<UserState>) {
  const localStorageKey = '__user';
  return (state: UserState | undefined, action: Action) => {
    if (state === undefined) {
      const persisted = localStorage.getItem(localStorageKey);
      return persisted ? JSON.parse(persisted) : _reducer(state, action);
    }
    const nextState = _reducer(state, action);
    if(action.type=="[User] Login Success"){
      localStorage.setItem(localStorageKey, JSON.stringify(nextState));
    }
    else if(action.type=='[User] Logout')
      localStorage.removeItem(localStorageKey);
    return nextState;
  };
}
    
export const metaReducers: MetaReducer<any>[] = [persistStateReducer];