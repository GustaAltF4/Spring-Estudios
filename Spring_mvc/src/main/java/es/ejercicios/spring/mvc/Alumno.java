package es.ejercicios.spring.mvc;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import es.ejercicios.spring.mvc.validacionesPersonalizadas.CpostalMendoza;

public class Alumno {

	//se agregan campos a verificar
	@NotNull
	@Size(min=2,message="*!Campo Obligatorio")//luego hay q especificar la validacion en el controlador
	private String nombre;
	private String apellido;
	private String optativa;
	private String ciudadCede;
	private String idiomasAlumno;
	@Min(value=10, message="*!Edad minima estipulada: 10")
	@Max(value=100,message="*!Edad maxima estipulada: 100")
	private int edad;
	@Email
	private String email;
	//@Pattern(regexp="[0-9]{4}", message="solo se admiten 4 valores numericos")//regexp="[solo caracteres del 0al 9]{numero de caracteres}"
	@CpostalMendoza
	private String codigoPostal;//si se permitieran letras se podria poner regexp="[0-9a-zA-Z]{7}" o [a-zA-Z0-9]
	

	//GETTERS Y SETTERS
	
	

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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getOptativa() {
		return optativa;
	}
	public void setOptativa(String optativa) {
		this.optativa = optativa;
	}
	public String getCiudadCede() {
		return ciudadCede;
	}
	public void setCiudadCede(String ciudadCede) {
		this.ciudadCede = ciudadCede;
	}
	public String getIdiomasAlumno() {
		return idiomasAlumno;
	}
	public void setIdiomasAlumno(String idiomasAlumno) {
		this.idiomasAlumno = idiomasAlumno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
}
