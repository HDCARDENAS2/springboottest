package com.prueba.model.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.prueba.controller.constants.MsgUsuarioDTOConstants;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */

public class UsuarioDTO {

	private Integer id;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_NOMBRES)
	@Size(min = 1, max = 100, message = MsgUsuarioDTOConstants.MSG_MAX_NOMBRES)
	private String nombres;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_IDENTIFICACION)
	@Size(min = 1, max = 20, message = MsgUsuarioDTOConstants.MSG_MAX_IDENTIFICACION)
	private String identificacion;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_APELLIDOS)
	@Size(min = 1, max = 20, message = MsgUsuarioDTOConstants.MSG_MAX_APELLIDOS)
	private String apellidos;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_EDAD)
	private Short edad;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_SEXO)
	private Character sexo;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_CIUDADRESIDENCIA)
	@Size(min = 1, max = 100, message = MsgUsuarioDTOConstants.MSG_MAX_CIUDADRESIDENCIA)
	private String ciudadResidencia;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_USUARIO)
	@Size(min = 1, max = 100, message = MsgUsuarioDTOConstants.MSG_MAX_USUARIO)
	private String usuario;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_CLAVE)
	@Size(min = 1, max = 20, message = MsgUsuarioDTOConstants.MSG_MAX_CLAVE)
	private String clave;
	@NotNull(message = MsgUsuarioDTOConstants.MSG_NULL_FECHANACIMIENTO)
	private String fechaNacimiento;

	public UsuarioDTO() {

	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Short getEdad() {
		return this.edad;
	}

	public void setEdad(Short edad) {
		this.edad = edad;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getCiudadResidencia() {
		return this.ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
