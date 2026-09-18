import { Component, OnInit, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router/';
import { CartService } from '../cart/cart-service';

@Component({
  selector: 'taco-design',
  templateUrl: 'design.component.html',
  styleUrls: ['./design.component.css']
})

@Injectable()
export class DesignComponent implements OnInit {

  model = {
    name: '',
    ingredients: [] as any[]
  };

  allIngredients: any[] = [];
  wraps: any[] = [];
  proteins: any[] = [];
  veggies: any[] = [];
  cheeses: any[] = [];
  sauces: any[] = [];

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private cart: CartService
  ) {
  }

  // tag::ngOnInit[]
  ngOnInit() {
    this.httpClient.get<any[]>('http://localhost:8082/api/ingredients')
      .subscribe(data => {
        this.allIngredients = data;

        this.wraps = this.allIngredients.filter((w: any) => w.type === 'WRAP');
        this.proteins = this.allIngredients.filter((p: any) => p.type === 'PROTEIN');
        this.veggies = this.allIngredients.filter((v: any) => v.type === 'VEGGIES');
        this.cheeses = this.allIngredients.filter((c: any) => c.type === 'CHEESE');
        this.sauces = this.allIngredients.filter((s: any) => s.type === 'SAUCE');
      });
  }
  // end::ngOnInit[]

  updateIngredients(ingredient: any, event: any) {
    if (event.target.checked) {
      this.model.ingredients.push(ingredient);
    } else {
      const index = this.model.ingredients.findIndex(
        (i: any) => i === ingredient
      );

      if (index !== -1) {
        this.model.ingredients.splice(index, 1);
      }
    }
  }

  // tag::onSubmit[]
  onSubmit() {
    this.httpClient.post(
      'http://localhost:8082/api/tacos',
      this.model,
      {
        headers: new HttpHeaders()
          .set('Content-type', 'application/json'),
      }
    ).subscribe(taco => this.cart.addToCart(taco));

    this.router.navigate(['/cart']);
  }
  // end::onSubmit[]

}

