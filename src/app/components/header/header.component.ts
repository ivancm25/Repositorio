import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuariosService } from 'src/app/services/usuarios/usuarios.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  usuarioForm: FormGroup;
  loginForm: FormGroup;
  usuarios: any;
  static logeado: boolean = false;
  static usuarioRegistrado: any;
  public classReference = HeaderComponent;

  constructor(
    public fb: FormBuilder,
    public fb2: FormBuilder,
    public usuarioService: UsuariosService
    ) { }

  ngOnInit(): void {
    this.loginForm = this.fb2.group({
      id : [''],
		  email : ['', Validators.required],
		  contrasena : ['', Validators.required]
    })

    this.usuarioForm = this.fb.group({
      id : [''],
      nombre : ['', Validators.required],
		  apellido : ['', Validators.required],
		  email : ['', Validators.required],
		  contrasena : ['', Validators.required]
    })

    this.usuarioService.getAllUsuarios().subscribe(resp=>{
      this.usuarios = resp;
    },
      error=>{ console.error(error) }
    )
  }

  public guardarUsuario(): void {
    this.usuarioService.saveUsuario(this.usuarioForm.value).subscribe(resp=>{
      this.usuarioForm.reset();
      this.usuarios = this.usuarios.filter((usuario: { id: any; })=> resp.id!=usuario.id);
      this.usuarios.push(resp);
    },
      error=>{ console.error(error) }
    )
  }

  public eliminar(usuario:any) {
    this.usuarioService.deleteUsuario(usuario.id).subscribe(resp=>{
      if (resp === true) {
        this.usuarios.pop(usuario);
      }
      this.usuarioForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editar(usuario:any) {
    this.usuarioForm.setValue({
      id : usuario.id,
      nombre : usuario.nombre,
		  apellido : usuario.apellido,
		  email : usuario.email,
		  contrasena : usuario.contrasena
    })
  }

  public login() {
    for (let user of this.usuarios) {
      if (this.loginForm.value.email == user.email && this.loginForm.value.contrasena == user.contrasena) {
        this.classReference.logeado = true;
        this.classReference.usuarioRegistrado = user;
      }
    }
  }

  public getLogeado() {
    return this.classReference.logeado;
  }

  public cerrarSesion() {
    if (this.classReference.logeado) {
      this.classReference.logeado = false;
    }
  }

}
