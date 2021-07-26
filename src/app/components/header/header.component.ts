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
  usuarios: any;

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuariosService
    ) { }

  ngOnInit(): void {

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

}
