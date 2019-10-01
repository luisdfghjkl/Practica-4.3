


public class SaldoIncorrecto extends Exception{
	public SaldoIncorrecto () {
		super ("Saldo Incorrecto ");
	}
	
	public boolean validar(String cadena) {
	      if (cadena.matches("[0-9]*")) {
	         return true;
	      } else {
	         return false;
	      }
	   }
}
