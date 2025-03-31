package br.com.pamela.moblie.seg.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario {
    //atributos
    private String nome;
    private String telefone;
    private String email;
    private String senha;

    //CONSTRUTOR
    public Usuario(JSONObject jp)
    {
        try
        {
            this.setNome(jp.getString("nome"));
            this.setTelefone(jp.getString("telefone"));
            this.setEmail(jp.getString("email"));
            this.setSenha(jp.getString("senha"));
        }
        catch
        (JSONException e) {
            e.printStackTrace();
        }
    }
//CONSTRUTOR

    //Inicializa os atributos paragerarObjetoJson
    public Usuario()
    {
        this.setNome("");
        this.setSenha("");
        this.setEmail("");
        this.setTelefone("");
    }
    //Metodo
    public JSONObject toJsonObject()
    {
        JSONObject json = new JSONObject();
        try
        {
            json.put("nome", this.nome);
            json.put("senha", this.senha);
            json.put("email", this.email);
            json.put("telefone", this.telefone);
        }
        catch
        (JSONException e)
        {
            e.printStackTrace();
        }
        return json;
    }

        // metodos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
