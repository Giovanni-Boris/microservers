import { UserData } from "../../shared/interfaces/user.model";

export interface UserState {
  user: UserData | null;
  isFetching: boolean;
  error: any;
}

export const initialState: UserState = {
  user: null,
  isFetching: false,
  error: "",
};
