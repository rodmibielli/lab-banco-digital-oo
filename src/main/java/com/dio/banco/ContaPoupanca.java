package com.dio.banco;

/**
 * Modela um tipo de conta poupanca.
 */
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente,TipoConta.Poupanca);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
}
