
package com.senai.apirest.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "produtos")
@Entity()
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long IDProduto;
    
    @Column(nullable = false)
    private String nomeProduto;
    
    @Column(nullable = true)
    private String descricaoProduto;
    
    @Column(nullable = true)
    private Double valorProduto;
    
    @OneToOne
    private VendasProduto vendasProduto;

    public void setVendasProduto(VendasProduto vendasProduto) {
        this.vendasProduto = vendasProduto;
    }

    public VendasProduto getVendasProduto() {
        return vendasProduto;
    }

    public void setIDProduto(Long IDProduto) {
        this.IDProduto = IDProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Long getIDProduto() {
        return IDProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }
    
    
}
