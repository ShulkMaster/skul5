package com.example.skul5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "student")
public class Student {

    public Student() {
    }

    @Id
    @Column(name = "code")
    @NotEmpty(message = "El carnet es obligatorio")
    @Size(message = "El carnet debe tener maximo 10 caracteres", max = 10)
    private String code;

    @Column(name = "student_name")
    @NotEmpty(message = "El nombre es obligatorio")
    @Size(message = "El nombre debe tener maximo 50 caracteres", max = 50)
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "El apellido es obligatorio")
    @Size(message = "El apellido debe tener maximo 50 caracteres", max = 50)
    private String lastName;

    @Column(name = "career")
    @NotEmpty(message = "La carrera es obligatoria")
    @Size(message = "La carrera debe tener maximo 100 caracteres", max = 100)
    private String career;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCareer() { return career; }

    public void setCareer(String career) { this.career = career; }
}
