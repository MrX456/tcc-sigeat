/*
 * Classe responsável por guardar os dados do usuário logado
 */

package com.sigeat.controller;

/*
 * SIGEAT/ Controller / Session
 * @author Junior
 * Version : 1.0.0
 */

public abstract class Session {
    
    private static String nome;
    
    private static String login;
    
    private static String perfil;

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Session.nome = nome;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Session.login = login;
    }

    public static String getPerfil() {
        return perfil;
    }

    public static void setPerfil(String perfil) {
        Session.perfil = perfil;
    }
    
}
