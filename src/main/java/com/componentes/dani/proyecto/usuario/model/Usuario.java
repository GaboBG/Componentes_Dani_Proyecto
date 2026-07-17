package com.componentes.dani.proyecto.usuario.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "gabriel_proyecto_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^[0-9]{8}$",
            message = "El teléfono debe tener 8 dígitos (Costa Rica)"
    )
    private String telefono;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String constrasenna;

    public Usuario() {}




    public Usuario(Long id, String nombre, String correo, String telefono, String constrasenna) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.constrasenna = constrasenna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getConstrasenna() {
        return constrasenna;
    }

    public void setConstrasenna(String constrasenna) {
        this.constrasenna = constrasenna;
    }
}