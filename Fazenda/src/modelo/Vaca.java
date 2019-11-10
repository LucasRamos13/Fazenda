/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Avell
 */
public class Vaca {
    private Integer codigo;
    private Integer origem;
    private Integer situacao;
    private LocalDate nascimento;
    private String observacao;
    private Integer maeVaca;
    private Integer RacaVaca;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getMaeVaca() {
        return maeVaca;
    }

    public void setMaeVaca(Integer maeVaca) {
        this.maeVaca = maeVaca;
    }

    public Integer getRacaVaca() {
        return RacaVaca;
    }

    public void setRacaVaca(Integer RacaVaca) {
        this.RacaVaca = RacaVaca;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaca other = (Vaca) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vaca{" + "codigo=" + codigo + ", maeVaca=" + maeVaca + ", RacaVaca=" + RacaVaca + '}';
    }
    
    
}
