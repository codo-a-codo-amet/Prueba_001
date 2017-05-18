/* Este codigo ha sido generado por el modulo psexport 20160506-w32 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "LOGIN.java."

// Hay dos errores que se pueden generar al exportar un algoritmo con subprocesos desde PSeint a Java:
// 1) En java no se puede elegir entre pasaje por copia o por referencia. Técnicamente solo existe el
// pasaje por copia, pero los identificadores de objetos representan en realidad referencias a los
// objetos. Entonces, el pasaje para tipos nativos actúa como si fuera por copia, mientras que el
// pasaje para objetos (como por ejemplo String) actúa como si fuera por referencia. Esto puede llevar
// a que el algoritmo exportado no se comporte de la misma forma que el algoritmo original, en cuyo
// caso deberán modificarse algunos métodos (subprocesos exportados) para corregir el problema.
// 2) Las funciones que hacen lectura por teclado deben lazar una excepción. Si una función A es
// invocada por otra B, B también debe manejar (lanzar en este caso) las execpciones que lance A.
// Esto no se cumple en el código generado automáticamante: las funciones que realizan lecturas
// directamente incluyen el código que indica que pueden generar dicha excepción, pero las que
// lo hacen indirectamente (invocando a otras que sí lo hacen), puede que no, y deberán ser
// corregidas manualmente.

import java.io.*;

public class login {

	public static boolean checklogin(String function_user, String function_password) {
		String dbpass;
		String dbuser;
		boolean islogincorrect;
		dbuser = "Juan";
		dbpass = "Topo";
		islogincorrect = (function_user.equals(dbuser)) && (function_password.equals(dbpass));
		return islogincorrect;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
		double count;
		boolean islogincorrect;
		String password;
		String user;
		count = 0;
		do {
			System.out.println("Ingrese Usuario");
			user = bufEntrada.readLine();
			System.out.println("Ingrese Contraseña");
			password = bufEntrada.readLine();
			count = count+1;
			islogincorrect = checklogin(user,password);
			if (islogincorrect) {
				System.out.println("Bienvenido "+user);
			} else {
				System.out.println("Usuario y/o contraseña incorrectos");
			}
		} while (count<3 || islogincorrect);
		if (count>=3) {
			System.out.println("Sos un pancho... bloqueaste el usuario");
		}
	}


}

