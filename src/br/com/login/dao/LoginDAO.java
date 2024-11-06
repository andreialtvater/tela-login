/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author andrei
 */
public class LoginDAO {

    private Component rootPane;
    
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO login (nome, email, senha) VALUES (?,?,?)";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.setString(1, nome);
        statment.setString(2, email);
        statment.setString(3, senha);
        statment.execute();
        conexao.close();
    }
    
    public void loginUsuario(String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM login WHERE email = ? AND senha = ?";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.setString(1, email);
        statment.setString(2, senha);
        ResultSet rs = statment.executeQuery();

        if (rs.next()) {

            JOptionPane.showMessageDialog(rootPane, "Login Realizado!");
        } else {
            
            JOptionPane.showMessageDialog(rootPane, "Login ou Senha Incorretos!");
        }
        conexao.close();   
    }

}
