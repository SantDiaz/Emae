import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  formData = {
    nombre: '',
    email: '',
    subject: '',
    message: ''
  };
  selectedFile: File | null = null;

  constructor(private http: HttpClient) { }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.selectedFile = input.files[0];
    } else {
      this.selectedFile = null;
    }
  }

  onSubmit(): void {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('nombre', this.formData.nombre);
      formData.append('email', this.formData.email);
      formData.append('subject', this.formData.subject);
      formData.append('message', this.formData.message);
      formData.append('archivo', this.selectedFile, this.selectedFile.name);

      this.http.post('http://localhost:8080/upload', formData).subscribe(
        response => console.log('Formulario enviado con éxito', response),
        error => {
          console.error('Error en el envío del formulario', error);
          if (error.status === 0) {
            console.error('El servidor backend podría estar caído o hay un problema de CORS.');
          }
        }
      );
    } else {
      console.error('No se ha seleccionado ningún archivo.');
    }
  }
}
