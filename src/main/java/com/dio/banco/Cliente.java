package com.dio.banco;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Modela um cliente com um nome.
 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Cliente {

	@Getter
	private final @NonNull String nome;

}
