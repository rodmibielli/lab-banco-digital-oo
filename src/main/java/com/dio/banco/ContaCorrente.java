package com.dio.banco;

/**
 * Modela um tipo de conta corrente.
 */
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente,TipoConta.Corrente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
}
