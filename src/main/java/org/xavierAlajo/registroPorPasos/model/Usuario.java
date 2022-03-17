package org.xavierAlajo.registroPorPasos.model;

public class Usuario {
	private	String nombre;
	private	String apellido; 
	private	String fechaNacimiento;
	private String siglasGenero;
	private String estadoCivil;
	private String nacionalidad;
	private String departamento;
	private  double salario; 
	private  String comentarios; 
	private  int numeroCuenta;

	    
// CONSTRUCTOR CON TODOS LOS PARÁMETROS  
	public Usuario(
			String nombre, 
			String apellido, 
			String fechaNacimiento,
			String siglasGenero, 
			String estadoCivil,
			String nacionalidad, 
			String departamento,
			double salario, 
			String comentarios,  
			int numeroCuenta) {
	super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.siglasGenero = siglasGenero;
		this.estadoCivil = estadoCivil;
		this.nacionalidad = nacionalidad;
		this.departamento = departamento;
		this.salario = salario;
		this.comentarios = comentarios;
		this.numeroCuenta = numeroCuenta;
		}



// CONSTRUCTOR VACIO
	public Usuario() {
		super();
	}
	
// GETTER Y SETTER
	

public String getNombre() {
	return nombre;
}



public void setNombre(String nombre) {
	this.nombre = nombre;
}



public String getApellido() {
	return apellido;
}



public void setApellido(String apellido) {
	this.apellido = apellido;
}



public String getFechaNacimiento() {
	return fechaNacimiento;
}



public void setFechaNacimiento(String fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}



public String getSiglasGenero() {
	return siglasGenero;
}



public String getEstadoCivil() {
	return estadoCivil;
}



public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
}



public void setSiglasGenero(String siglasGenero) {
	this.siglasGenero = siglasGenero;
}



public String getNacionalidad() {
	return nacionalidad;
}



public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}



public String getDepartamento() {
	return departamento;
}



public void setDepartamento(String departamento) {
	this.departamento = departamento;
}



public double getSalario() {
	return salario;
}



public void setSalario(double salario) {
	this.salario = salario;
}



public String getComentarios() {
	return comentarios;
}



public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}



public int getNumeroCuenta() {
	return numeroCuenta;
}



public void setNumeroCuenta(int numeroCuenta) {
	this.numeroCuenta = numeroCuenta;
}



	
	
	

// metodo para recoger los datos del Formulario paso 1
public void setUsuarioPaso1(Usuario usuario1) {
	this.nombre = usuario1.getNombre();
	this.apellido = usuario1.getApellido();
	this.fechaNacimiento = usuario1.getFechaNacimiento();
	this.siglasGenero = usuario1.getSiglasGenero();
	this.estadoCivil = usuario1.getEstadoCivil();
	this.nacionalidad = usuario1.getNacionalidad();
}


//metodo para recoger los datos del Formulario paso 2
public void setUsuarioPaso2(Usuario usuario2) {
	 this.departamento = usuario2.getDepartamento();
	 this.salario = usuario2.getSalario();
	 this.comentarios = usuario2.getComentarios ();	 
} 

//metodo para recoger los datos del Formulario paso 3
public void setUsuarioPaso3(Usuario usuario3) {
	 this.numeroCuenta = usuario3.getNumeroCuenta();	    
	}	
}
