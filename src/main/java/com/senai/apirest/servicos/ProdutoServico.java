/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.apirest.servicos;
import com.senai.apirest.entidades.Cliente;
import com.senai.apirest.entidades.Produto;
import com.senai.apirest.repositorios.ProdutoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gustavo_h_bueno
 */
public class ProdutoServico {
    
      @Autowired
    private ProdutoRepositorio produtoRepositorio;
    
    public Long incluirProduto(Produto produto){
        return produtoRepositorio.save(produto).getIDProduto();
    }
    
    public Boolean excluirProduto(Long idProduto){
        
        try{
            produtoRepositorio.deleteById(idProduto);
            return true;
        } catch(Exception ex){
            System.out.println("Erro ao excluir"
                             + " cliente ID: " + idProduto
                             + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }
    
    public Optional<Produto> consultarCliente(Long idProduto){
        
        return produtoRepositorio.findById(idProduto);
    }
    public List<Produto> listarProduto(){
        
        return produtoRepositorio.findAll();
    }
    
    public Boolean atualizarProduto(Produto produto) {
        
        Produto pro = produtoRepositorio.getReferenceById(produto.getIDProduto());
        if( pro != null) {
            pro.setDescricaoProduto(produto.getDescricaoProduto());
            pro.setNomeProduto(produto.getNomeProduto());
            pro.setValorProduto(produto.getValorProduto());
            pro.setVendasProduto(produto.getVendasProduto());
            produtoRepositorio.save(produto);
            return true;
        } else {
            return false;            
    }
        
        
        
    }
}
