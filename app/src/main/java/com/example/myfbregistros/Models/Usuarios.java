package com.example.myfbregistros.Models;

public class Usuarios {
    String id;
    String nombre;
    String correo;
    String urlImagen;
    String descripcion;

    public Usuarios() {
    }

    public Usuarios(String id, String nombre, String correo, String urlImagen, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
