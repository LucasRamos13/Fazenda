/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Avell
 */
public class Inseminacao {
    private Integer codigo;
    private LocalDate data;
    private String observacao;
    private Integer situacao;
    private Integer vaca;
    private Integer touro;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Integer getVaca() {
        return vaca;
    }

    public void setVaca(Integer vaca) {
        this.vaca = vaca;
    }

    public Integer getTouro() {
        return touro;
    }

    public void setTouro(Integer touro) {
        this.touro = touro;
    }

    @Override
    public String toString() {
        return "Inseminacao{" + "data=" + data + ", vaca=" + vaca + '}';
    }
    
    
}
