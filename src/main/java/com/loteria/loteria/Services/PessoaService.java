package com.loteria.loteria.Services;

import com.loteria.loteria.Models.Pessoa;
import com.loteria.loteria.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repo;

    public Pessoa buscar(String email){
        Optional<Pessoa> obj = repo.findByEmail(email);
        return obj.orElse(null);
    }
    public Pessoa insert(Pessoa pessoa){
        Pessoa obj = buscar(pessoa.getEmail());

        Random numero = new Random();
        int valor1 = numero.nextInt((100 - 0) + 1) + 0;
        int valor2 = numero.nextInt((100 - 0) + 1) + 0;
        int valor3 = numero.nextInt((100 - 0) + 1) + 0;
        int valor4 = numero.nextInt((100 - 0) + 1) + 0;
        ArrayList<Integer> numerosSorteados = new ArrayList<Integer>();
        numerosSorteados.add(valor1);
        numerosSorteados.add(valor2);
        numerosSorteados.add(valor3);
        numerosSorteados.add(valor4);

        if(obj != null) {
            obj.getNumerosSorteados().addAll(numerosSorteados);
            return repo.save(obj);

        }

        pessoa.getNumerosSorteados().addAll(numerosSorteados);
        return repo.save(pessoa);

    }
}
