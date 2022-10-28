import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/types/User';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  user: null | User = null;

  login(email: string, password: string) {
    const user = this.http.post<User>('/api/login', { email, password });
    console.log(user);
  }
}
