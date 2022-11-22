package com.netbiis.wassabiapp_jsp.core.utils;

import java.util.function.Predicate;

public class ValidatorUtil {
	public static Predicate<String> email = (value) -> value.matches("[\\w|.]{3,}[@][\\w|.]{3,}");
	public static Predicate<String> cpf = (value) -> value.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
	public static Predicate<String> telefone = (value) -> value.matches("[(][0-9]{2}[)] [0-9]{5}-[0-9]{4}");
}
