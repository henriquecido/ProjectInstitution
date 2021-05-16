/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Login;

/**
 *
 * @author User
 */
public interface LoginDAO {
    public boolean salvar(Login log);
    public boolean login(Login log);
}
