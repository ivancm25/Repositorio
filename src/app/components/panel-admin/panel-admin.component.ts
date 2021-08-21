import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { HotelesService } from 'src/app/services/hoteles/hoteles.service';
import { ApartamentosService } from 'src/app/services/apartamentos/apartamentos.service';
import { HeaderComponent } from '../header/header.component';
import { CasasRuralesService } from 'src/app/services/casas-rurales/casas-rurales.service';
import { HabitacionesService } from 'src/app/services/habitaciones/habitaciones.service';
import { UsuariosService } from 'src/app/services/usuarios/usuarios.service';

@Component({
  selector: 'app-panel-admin',
  templateUrl: './panel-admin.component.html',
  styleUrls: ['./panel-admin.component.css']
})

export class PanelAdminComponent implements OnInit {
  usuarioForm: FormGroup;
  usuarios: any;
  verFormularioUsuario: boolean = false;

  public casaRuralForm: FormGroup;
  casasRurales: any;
  verFormularioCasaRural: boolean = false;

  public hotelForm: FormGroup;
  hoteles: any;
  verFormularioHotel: boolean = false;

  public habitacionForm: FormGroup;
  habitaciones: any;
  verFormularioHabitacion: boolean = false;

  public apartamentoForm: FormGroup;
  public headerComponent: HeaderComponent;
  apartamento: any;
  apartamentos: any;
  verFormularioApartamento: boolean = false;

  public classReference = HeaderComponent;

  constructor(
    public fb: FormBuilder,
    public usuarioService: UsuariosService,
    public hotelService: HotelesService,
    public habitacionService: HabitacionesService,
    public apartamentoService: ApartamentosService,
    public casaRuralService: CasasRuralesService
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

    this.hotelForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      habitaciones: ['', Validators.required],
      piscina: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.hotelService.getAllHoteles().subscribe(resp => {
      this.hoteles = resp;
    },
      error => { console.error(error) }
    )

    this.apartamentoForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required],
      mascotas: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.apartamentoService.getAllApartamentos().subscribe(resp => {
      this.apartamentos = resp;
    },
      error => { console.error(error) }
    )

    this.casaRuralForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      provincia: ['', Validators.required],
      direccion: ['', Validators.required],
      tlf: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required],
      piscina: ['', Validators.required],
      mascotas: ['', Validators.required],
      fumadores: ['', Validators.required]
    });

    this.casaRuralService.getAllCasasRurales().subscribe(resp => {
      this.casasRurales = resp;
    },
      error => { console.error(error) }
    )

    this.habitacionForm = this.fb.group({
      id : [''],
      nombre: ['', Validators.required],
      hotel: ['', Validators.required],
      precio: ['', Validators.required],
      huespedes: ['', Validators.required]
    });

    this.habitacionService.getAllHabitaciones().subscribe(resp => {
      this.habitaciones = resp;
    },
      error => { console.error(error) }
    )
  }

  public guardarUsuario(): void {
    this.usuarioService.saveUsuario(this.usuarioForm.value).subscribe(resp=>{
      this.usuarioForm.reset();
      this.usuarios = this.usuarios.filter((usuario: { id: any; })=> resp.id!=usuario.id);
      this.usuarios.push(resp);
    },
      error=>{ console.error(error) }
    );
    this.verFormularioUsuario = false;
  }

  public eliminarUsuario(usuario:any) {
    this.usuarioService.deleteUsuario(usuario.id).subscribe(resp=>{
      if (resp === true) {
        this.usuarios.pop(usuario);
      }
      this.usuarioForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editarUsuario(usuario:any) {
    this.verFormularioUsuario = true;
    this.usuarioForm.setValue({
      id : usuario.id,
      nombre : usuario.nombre,
		  apellido : usuario.apellido,
		  email : usuario.email,
		  contrasena : usuario.contrasena
    });
  }

  public guardarHotel(): void {
    this.hotelService.saveHotel(this.hotelForm.value).subscribe(resp=>{
      this.hotelForm.reset();
      this.hoteles = this.hoteles.filter((hotel: { id: any; })=> resp.id != hotel.id);
      this.hoteles.push(resp);
    },
      error=>{ console.error(error) }
    );
    this.verFormularioHotel = false;
  }

  public eliminarHotel(hotel:any) {
    this.hotelService.deleteHotel(hotel.id).subscribe(resp=>{
      if (resp === true) {
        this.hoteles.pop(hotel);
      }
      this.hotelForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editarHotel(hotel:any) {
    this.verFormularioHotel = true;
    this.hotelForm.setValue({
      id : hotel.id,
      nombre: hotel.nombre,
      provincia: hotel.provincia,
      direccion: hotel.direccion,
      tlf: hotel.tlf,
      habitaciones: hotel.habitaciones,
      piscina: hotel.piscina,
      fumadores: hotel.fumadores
    })
  }

  public guardarApartamento(): void {
    this.apartamentoService.saveApartamento(this.apartamentoForm.value).subscribe(resp=>{
      this.apartamentoForm.reset();
      this.apartamentos = this.apartamentos.filter((apartamento: { id: any; })=> resp.id != apartamento.id);
      this.apartamentos.push(resp);
    },
      error=>{ console.error(error) }
    );
    this.verFormularioApartamento = false;
  }

  public eliminarApartamento(apartamento:any) {
    this.apartamentoService.deleteApartamento(apartamento.id).subscribe(resp=>{
      if (resp === true) {
        this.apartamentos.pop(apartamento);
      }
      this.apartamentoForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editarApartamento(apartamento:any) {
    this.verFormularioApartamento = true;
    this.apartamentoForm.setValue({
      id : apartamento.id,
      nombre: apartamento.nombre,
      provincia: apartamento.provincia,
      direccion: apartamento.direccion,
      tlf: apartamento.tlf,
      precio: apartamento.precio,
      huespedes: apartamento.huespedes,
      mascotas: apartamento.mascotas,
      fumadores: apartamento.fumadores
    })
  }

  public estaLogeado() {
    return this.headerComponent.getLogeado();
  }



  public guardarCasaRural(): void {
    this.casaRuralService.saveCasaRural(this.casaRuralForm.value).subscribe(resp=>{
      this.casaRuralForm.reset();
      this.casasRurales = this.casasRurales.filter((casaRural: { id: any; })=> resp.id != casaRural.id);
      this.casasRurales.push(resp);
    },
      error=>{ console.error(error) }
    );
    this.verFormularioCasaRural = false;
  }

  public eliminarCasaRural(casaRural:any) {
    this.casaRuralService.deleteCasaRural(casaRural.id).subscribe(resp=>{
      if (resp === true) {
        this.casasRurales.pop(casaRural);
      }
      this.casaRuralForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editarCasaRural(casaRural:any) {
    this.verFormularioCasaRural = true;
    this.casaRuralForm.setValue({
      id : casaRural.id,
      nombre: casaRural.nombre,
      provincia: casaRural.provincia,
      direccion: casaRural.direccion,
      tlf: casaRural.tlf,
      precio: casaRural.precio,
      huespedes: casaRural.huespedes,
      piscina: casaRural.piscina,
      mascotas: casaRural.mascotas,
      fumadores: casaRural.fumadores
    })
  }

  public guardarHabitacion(): void {
    console.log(this.habitacionForm.value);
    this.habitacionService.saveHabitacion(this.habitacionForm.value).subscribe(resp=>{
      this.habitacionForm.reset();
      this.habitaciones = this.habitaciones.filter((habitacion: { id: any; })=> resp.id != habitacion.id);
      this.habitaciones.push(resp);
    },
      error=>{ console.error(error) }
    );
    this.verFormularioHabitacion = false;
  }

  public eliminarHabitacion(habitacion:any) {
    this.habitacionService.deleteHabitacion(habitacion.id).subscribe(resp=>{
      if (resp === true) {
        this.habitaciones.pop(habitacion);
      }
      this.habitacionForm.reset();
    },
      error=>{ console.error(error) }
    )
  }

  public editarHabitacion(habitacion:any) {
    this.verFormularioHabitacion = true;
    this.habitacionForm.setValue({
      id : habitacion.id,
      nombre: habitacion.nombre,
      hotel: habitacion.hotel,
      precio: habitacion.precio,
      huespedes: habitacion.huespedes
    })
  }

  public comprobarAdmin(usuario: any) {
    if (usuario.email == "admin@turismogal.com") {
      return true;
    } else {
      return false;
    }
  }
}
