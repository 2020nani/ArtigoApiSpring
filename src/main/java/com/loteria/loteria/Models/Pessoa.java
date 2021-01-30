package com.loteria.loteria.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "O e-mail precisa ser preenchido")
    @Email(message = "Formato de e-mail inválido")
    @Column( name="email", nullable = false, unique = true)
    private String email;
    @ElementCollection
    @CollectionTable(name="NumerosSorteados")
    private Set<Integer> numerosSorteados = new HashSet<>();

    public Pessoa(){

    }
    //construtor que deixa os atributos publicos para o sistema
    public Pessoa(Integer id, String email){
        this.id = id;
        this.email = email;

    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Integer> getNumerosSorteados() {
        return numerosSorteados;
    }

    public void setNumerosSorteados(Set<Integer> numerosSorteados) {
        this.numerosSorteados = numerosSorteados;
    }



}