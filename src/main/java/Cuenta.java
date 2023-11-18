/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lombok.Getter;

/**
 *
 * @author julia
 */
@Getter
public class Cuenta {
    private String usuario;
    private String contrasena;
    private double saldo;

    public Cuenta(String usuario, String contrasena, double saldo) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }
            
    public double depositar(double valor){
        this.saldo = this.saldo + valor;
        return this.saldo;
    }
    
    public double retirar(double valor) {
        if(this.saldo>= valor) {
            this.saldo = this.saldo - valor;            
        } else {
            throw new RuntimeException("El saldo en la cuenta es insuficiente");
        }
        return this.saldo;
    }

    public boolean transferencia(Cuenta cuentaDestino, double valor) {
        boolean correcto = true;
        if (valor <= 0) {
            correcto = false;
        } else if (saldo >= valor) {
            retirar(valor);
            cuentaDestino.depositar(valor);
        } else {
            correcto = false;
        }
        return correcto;
    }


    @Override
    public String toString() {
        return "Cuenta{" + " usuario = " + usuario + " Saldo " + saldo +'}';
    }
}
