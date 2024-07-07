package com.dio.banco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Modela um banco.
 */

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of="nome")
@ToString(exclude = "contas")
public class Banco {

	private final @NonNull String nome;
	private final List<Conta> contas = new ArrayList<>();

	public List<Conta> getContas() {
		return Collections.unmodifiableList(contas);
	}

}
