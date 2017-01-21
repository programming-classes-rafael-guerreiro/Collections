package recursion;

import java.math.BigDecimal;

public class Recursion {
	// o nome ficará como recursão m mas calcularemos o fatorial
	// 1! = 1 = 1 x 0!
	// 2! = 2x1 = 2 x 1!
	// 3! = 3x2x1 = 3 x 2!
	// 4! = 4x3x2x1 = 4 x 3!
	public BigDecimal factorial(int n) { // passei 4
		if (n == 0)
			return new BigDecimal(1);
		return new BigDecimal(n).multiply(factorial(n - 1));
		// 4 * factorial(3)
		// 3 * factorial (2)
		// 2 * factorial (1)
		// 1 * factorial (0)
		// 0 * factorial (-1)
		// Quando tivermos um erro nao devemos tratar com um try/catch, devemos
		// consertar o codigo
	}
}
