import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuariosService } from 'src/app/services/usuarios/usuarios.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  usuarioForm: FormGroup;

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuariosService
    ) { }

  ngOnInit(): void {

    this.usuarioForm = this.fb.group({
      nombre : ['', Validators.required],
		  apellido : ['', Validators.required],
		  email : ['', Validators.required],
		  contrasena : ['', Validators.required]
    })
  }

  public guardarUsuario(): void {

  }

}
