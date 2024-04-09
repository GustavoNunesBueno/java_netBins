
package com.senai.apirest.servicos;

import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.repositorios.ClienteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServico {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    public Long incluirCliente(Cliente cliente){
        return clienteRepositorio.save(cliente).getIDCliente();
    }
    
    public Boolean excluirCliente(Long idCliente){
        
        try{
            clienteRepositorio.deleteById(idCliente);
            return true;
        } catch(Exception ex){
            System.out.println("Erro ao excluir"
                             + " cliente ID: " + idCliente
                             + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }
    
    public Optional<Cliente> consultarCliente(Long idCliente){
        
        return clienteRepositorio.findById(idCliente);
    }
    public List<Cliente> listarClientes(){
        
        return clienteRepositorio.findAll();
    }
    
    public Boolean atualizarCliente(Cliente cliente) {
        
        Cliente cli = clienteRepositorio.getReferenceById(cliente.getIDCliente());
        if( cli != null) {
            cli.setCpf(cliente.getCpf());
            cli.setEmail(cliente.getEmail());
            cli.setNome(cliente.getNome());
            clienteRepositorio.save(cli);
            return true;
        } else {
            return false;            
    }
        
        
        
    }
    
    
    
    
    
    
}
