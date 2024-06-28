
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FormComponent } from './form.component';


@NgModule({
  declarations: [
    FormComponent,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    // MatDividerModule,
    // MatButtonModule
  ],
  exports: [
    FormComponent,
  ],
})
export class FormModule { }
