package com.dio.banco;

import java.util.Date;

/**
 * Interface que define um tipo de conta.
 */
public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirExtrato();
	
	void fecharConta();
	
}
