import { data, event } from 'cypress/types/jquery';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '@env/environment';
import { Observable } from 'rxjs';
import { Items } from './items';
import { appendFile } from 'fs';

@Injectable({ providedIn: 'root' })
export class ItemsService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getItems(): Observable<Items[]> {
    return this.http.get<Items[]>(`${this.apiServerUrl}/Items/allItems`);
  }

  public addItems(items: Items): Observable<Items> {
    return this.http.post<Items>(`${this.apiServerUrl}/Items/addItem`, items);
  }
  public deleteItem(itemsId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/Items/deleteItem/${itemsId}`);
  }
  public deleteAll(): Observable<Items> {
    return this.http.delete<Items>(`${this.apiServerUrl}/Items/deleteAll`);
  }
}
