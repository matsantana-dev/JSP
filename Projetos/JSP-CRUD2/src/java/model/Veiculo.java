/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author prampero
 */

public class Veiculo {
    private int codigo;
    private String descr;
    private int ano;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) {
        this.setCodigo(Integer.parseInt(codigo));
    }
    
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public void setAno(String ano) {
        this.setAno(Integer.parseInt(ano));
    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setPreco(String preco) {
        this.setPreco(Double.parseDouble(preco));
    }
    
}
