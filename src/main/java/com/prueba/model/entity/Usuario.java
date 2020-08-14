package com.prueba.model.entity;

/**
 * @author hernanC <dropimax@gmail.com>
 * @date 13/08/2020
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario"
    ,catalog="test"
)
public class Usuario implements java.io.Serializable {

    @Id 
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
     private Integer id;
    @Column(name="nombres", nullable=false, length=100)
     private String nombres;
    @Column(name="identificacion", unique = true, nullable=false, length=20)
     private String identificacion;    
    @Column(name="apellidos", nullable=false, length=100)
     private String apellidos;
    @Column(name="edad", nullable=false, length=3)
     private Short edad;
    @Column(name="sexo", nullable=false, length=1)
     private Character sexo;
    @Column(name="ciudad_residencia", nullable=false, length=100)
     private String ciudadResidencia;
    @Column(name="usuario", nullable=false, length=100)
     private String usuario;
	@Column(name = "clave", nullable = false, length = 65535)
     private String clave;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_nacimiento", nullable=false, length=10)
     private Date fechaNacimiento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_create", nullable=false, length=19)
     private Date dateCreate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_update", nullable=false, length=19)
     private Date dateUpdate;
     
    public Usuario() {
    	
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

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getDateCreate() {
        return this.dateCreate;
    }
    
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return this.dateUpdate;
    }
    
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }




}



