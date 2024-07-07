package com.dio.banco;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Classe abstrata que define uma conta generica.
 */
@EqualsAndHashCode(of= {"cliente","agencia","numero","tipoConta"})
@ToString
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	@Getter
	private final int agencia;
	
	@Getter
	private final int numero;
	
	@Getter
	private double saldo;
	
	@Getter
	private final @NonNull Cliente cliente;
	
	@Getter
	private final @NonNull TipoConta tipoConta;
	
	private EstadoConta estado = EstadoConta.Aberta;
	
	/**
	 * Define um tipo de conta.
	 */
	public static enum TipoConta { 
		Corrente,
		Poupanca
	}
	
	/**
	 * Define o estado da conta: se aberta ou fechada. Se estiver fechada, nenhuma operacao podera ser realizada.
	 */
	public static enum EstadoConta {
		Aberta,
		Fechada
	}

	/**
	 * Define uma conta generica de um cliente.
	 * @param cliente
	 * @param agencia
	 * @param numero
	 */
	protected Conta(final Cliente cliente,final TipoConta tipoConta) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
	}

	@Override
	public void sacar(double valor) {
		verificarSePodeEfetuarOperacao();
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		verificarSePodeEfetuarOperacao();
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		verificarSePodeEfetuarOperacao();
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public final void fecharConta() {
		verificarSePodeEfetuarOperacao();
		if (this.saldo>0) {
			this.sacar(this.saldo);
		}
		this.estado = EstadoConta.Fechada;
		this.imprimirExtrato();
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		if (this.estado == EstadoConta.Fechada) {
			System.out.println("**** CONTA FECHADA *****");
		}
	}
	
	public abstract void imprimirExtrato(); 
	
	private void verificarSePodeEfetuarOperacao() {
		if (estado == EstadoConta.Fechada) {
			throw new UnsupportedOperationException("Não é possível efetuar a operação desejada em contas fechadas!");
		}
	}

}
