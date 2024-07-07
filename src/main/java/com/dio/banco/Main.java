package com.dio.banco;

/**
 * Ponto principal de entrada.
 */
public class Main {

	public static void main(String[] args) {
		Cliente rodrigo = new Cliente("Rodrigo");
		
		Conta cc = new ContaCorrente(rodrigo);
		Conta poupanca = new ContaPoupanca(rodrigo);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
		poupanca.fecharConta();
		cc.fecharConta();
	}

}
