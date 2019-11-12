/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoInseminacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Inseminacao;
import tela.manutencao.ManutencaoInseminacao;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Avell
 */
public class ControladorInseminacao {
        public static void inserir(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        objeto.setVaca((Integer) man.comVaca.getSelectedItem());
        objeto.setSituacao((Integer) man.comSituacao.getSelectedItem());
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setTouro((Integer)man.comTouro.getSelectedItem());
        objeto.setObservacao(man.jtfObservacao.getText());
        
        
        boolean resultado = DaoInseminacao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    public static void alterar(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
    objeto.setVaca((Integer) man.comVaca.getSelectedItem());
        objeto.setSituacao((Integer) man.comSituacao.getSelectedItem());
        objeto.setData(LocalDate.parse(man.jtfData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setTouro((Integer)man.comTouro.getSelectedItem());
        objeto.setObservacao(man.jtfObservacao.getText());

        
        boolean resultado = DaoInseminacao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static void excluir(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoInseminacao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Data da inseminação");
        modelo.addColumn("Situação");
        modelo.addColumn("Vaca");
        modelo.addColumn("Touro");
        modelo.addColumn("Observações");
        List<Inseminacao> resultados = DaoInseminacao.consultar();
        for (Inseminacao objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getSituacao());
            linha.add(objeto.getVaca());
            linha.add(objeto.getTouro());
            linha.add(objeto.getObservacao());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
     public static void atualizaCampos(ManutencaoInseminacao man, int pk){ 
        Inseminacao objeto = DaoInseminacao.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfObservacao.setText(objeto.getObservacao());
        man.jtfData.setText(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        //man.jtfData.setText(objeto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.comTouro.setSelectedItem(objeto.getTouro());
        man.comVaca.setSelectedItem(objeto.getVaca());
        man.comSituacao.setSelectedItem(objeto.getSituacao());
        
        man.jtfCodigo.setEnabled(false);
        man.jtfPrevisao.setEnabled(false);//desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
     
}
