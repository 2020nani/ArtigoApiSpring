package com.loteria.loteria.Controllers;


import com.loteria.loteria.Services.PessoaService;
import com.loteria.loteria.Services.exception.ResourceNotFoundException;
import com.loteria.loteria.Models.Pessoa;
import com.loteria.loteria.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;



import javax.validation.Valid;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService service;

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> getPessoaByEmail(@PathVariable(value = "email") String emailPessoa)
            throws ResourceNotFoundException{
        Pessoa pessoa = service.buscar(emailPessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> salvarPessoa(@Valid @RequestBody Pessoa pessoa){
        pessoa = service.insert(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}").buildAndExpand(pessoa.getEmail()).toUri();
        return ResponseEntity.created(uri).build();
    }



}

