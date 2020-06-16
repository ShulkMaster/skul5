package com.example.skul5.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "estudiante")
public class Student implements Model {

    public Student() {
    }

    @Id
    @Column(name = "c_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "carne")
    @NotEmpty(message = "El carnet es obligatorio")
    @Size(message = "El carnet debe tener maximo 10 caracteres", max = 10)
    private String license;

    @Column(name = "nombre")
    @NotEmpty(message = "El nombre es obligatorio")
    @Size(message = "El nombre debe tener maximo 50 caracteres", max = 50)
    private String name;

    @Column(name = "apellido")
    @NotEmpty(message = "El apellido es obligatorio")
    @Size(message = "El apellido debe tener maximo 50 caracteres", max = 50)
    private String lastName;

    @Column(name = "carrera")
    @NotEmpty(message = "La carrera es obligatoria")
    @Size(message = "La carrera debe tener maximo 100 caracteres", max = 100)
    private String career;

    public Integer setCode() {
        return code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
