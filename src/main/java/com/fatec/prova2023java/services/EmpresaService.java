package com.fatec.prova2023java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.prova2023java.entities.Empresa;
import com.fatec.prova2023java.repository.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> getEmpresa(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(int id){
        return empresaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Empresa não encontrado")
        );
    }

    public void deleteById(int id) {
      
        Empresa empresa = getEmpresaById(id);
        empresaRepository.delete(empresa);
        }
    
}

