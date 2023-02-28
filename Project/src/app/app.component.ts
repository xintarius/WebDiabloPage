import { map } from 'rxjs/operators';
import { environment } from '@env/environment';
import { Component, OnInit } from '@angular/core';
import { Items } from './items';
import { ItemsService } from './items.service';
import { HttpErrorResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { data, event } from 'cypress/types/jquery';
import { read } from 'fs';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  private apiServerUrl = environment.apiBaseUrl;
  public item: Items[];
  public items: Items;

  constructor(private itemsService: ItemsService, private http: HttpClient) {}

  ngOnInit() {
    this.getItems();
  }

  filePath = 'src\\assets\\';

  selectedFile: any;
  imagePath: string;

  public getItems(): void {
    this.itemsService.getItems().subscribe(
      (response: Items[]) => {
        this.item = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  onFileSelected(event: any) {
    if (event && event.target && event.target.files) {
      var reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      reader.onload = (event: any) => {
        this.filePath = event.target.result;
      };
    }
  }
  public postItem(data: { id: number; runes: string; images: string; itemCode: string }) {
    const formData = new FormData();
    formData.append('runes', data.runes);
    formData.append('itemCode', data.itemCode);
    formData.append('image', this.selectedFile);
    this.onFileSelected(data.images);
    this.itemsService.addItems(data).subscribe((response) => {
      console.log(response);
    });
  }

  public deleteItem(data: { id: number; runes: string }): void {
    this.itemsService.deleteItem(data.id).subscribe((data) => {
      console.log(data);
    });
  }
  public deleteAll(items: Items): void {
    this.itemsService.deleteAll().subscribe((items) => {
      console.log(items);
    });
  }
}
