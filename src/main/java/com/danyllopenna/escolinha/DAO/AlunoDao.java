/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danyllopenna.escolinha.DAO;

import com.danyllopenna.escolinha.dominio.Aluno;
import com.danyllopenna.escolinha.factory.Conexao;
import java.sql.*;

/**
 *
 * @author danyl
 */
public class AlunoDao {
     StringBuilder sql = new StringBuilder();
    Connection conecta = Conexao.conectando();
    
    public void salvar(Aluno a){
        sql.append("insert into aluno_escola");
        sql.append(" (nome_aluno,sobrenome_aluno,matricula) ");
        sql.append("values(?,?,?)");
        
        try {
            PreparedStatement salvar = conecta.prepareStatement(sql.toString());
            salvar.setString(1,a.getNome());
            salvar.setString(2,a.getSobrenome());
            salvar.setInt(3,a.getMatricula());
            salvar.executeUpdate();
            System.out.println("gravado com sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void apagar(Aluno a){
    sql.append("delete from aluno_escola ");
    sql.append("where id_aluno = ?");
        try {
            PreparedStatement apagar = conecta.prepareStatement(sql.toString());
            apagar.setInt(1,a.getId_aluno());
            apagar.executeUpdate();
            System.out.println("apagado com sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void alterar(Aluno a){
    sql.append("Update aluno_escola ");
    sql.append("set nome_aluno=?,sobrenome_aluno=?,matricula=? ");
    sql.append("where id_aluno =?");
        try {
            PreparedStatement editar = conecta.prepareStatement(sql.toString());
            editar.setString(1,a.getNome());
            editar.setString(2,a.getSobrenome());
            editar.setInt(3,a.getMatricula());
            editar.setInt(4,a.getId_aluno());
            editar.executeUpdate();
            System.out.println("editado com sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
