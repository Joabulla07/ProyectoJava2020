package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;

    @Column(unique=true)
    private String mail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyy")
    private LocalDate fechaAlta;

    private String ciudad;
    private String provincia;
    private String pais;


    @JsonIgnore
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Posts> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public List<Posts> getPosts() {

        return posts == null ? null : new ArrayList<>(posts);
    }

    public void setPosts(List<Posts> posts) {

        if (posts == null) {
            this.posts = null;
        } else {
            this.posts = Collections.unmodifiableList(posts);
        }
    }

    public List<Comment> getComments() {
        return comments == null ? null : new ArrayList<>(comments);
    }

    public void setComments(List<Comment> comments) {

        if (comments == null) {
            this.comments = null;
        } else {
            this.comments = Collections.unmodifiableList(comments);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @JsonIgnore
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public LocalDate getFechaAlta() {

        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {

        this.fechaAlta = fechaAlta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
