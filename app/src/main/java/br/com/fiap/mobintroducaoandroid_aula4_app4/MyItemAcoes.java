package br.com.fiap.mobintroducaoandroid_aula4_app4;

/**
 * Created by michelfernandes on 07/08/15.
 */
public class MyItemAcoes {

    private String nome;
    private int status;
    private int valor=0;
    private boolean ativo=false;

    public MyItemAcoes(int status, String nome){
        this.status=status;
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
