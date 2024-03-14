import { createFeatureSelector, createSelector } from "@ngrx/store";
import { UserState } from "./user.state";

export const authFeature = createFeatureSelector<UserState>("user");

export const selectToken = createSelector(
  authFeature,
  (state) => state.user?.token,
);

export const selectIsFecthing = createSelector(
  authFeature,
  (state) => state.isFetching ,
);
export const selectIsError = createSelector(
  authFeature,
  (state) => state.error ,
);
export const selectTokenId = createSelector(
  authFeature,
  (state) => state.user?.token,
);
export const selectIsLogged = createSelector(
  authFeature,
  (state) => !!state.user
);
export const selectUserData = createSelector(
  authFeature,
  (state) => state.user?.user
);
