export interface UserInfoWrapper {
  data: UserData;
}

export interface UserData {
  token: string;
  user: User;
  teacher?: Teacher;
  student?: Student;
}

export interface User {
  id: number;
  username: string;
  name: string;
  lastname: string;
  roles: string[];
}

export interface Teacher {
  id: number;
  email: string;
  idUsuario: number;
}

export interface Student {
  id: number;
  address: string;
  birthday: string;
  idUsuario: number;
}