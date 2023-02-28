export interface Items {
  id: number;
  runes: string;
  images: string;
  itemCode: string;
}

const ELEMENT_DATA: Items[] = [];

export class TableColumnStylingExample {
  displayedColumns: string[] = ['id', 'runes', 'images'];
  dataSource = ELEMENT_DATA;
}
