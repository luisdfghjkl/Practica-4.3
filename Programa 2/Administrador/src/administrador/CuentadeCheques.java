package administrador;

//import swingtest.SaldoIncorrecto;
//import swingtest.SaldoNegativo;

public class CuentadeCheques {

	int NumeroDeCuenta;
	int Saldo;
	
	public CuentadeCheques(int Num) {
        this.NumeroDeCuenta = Num;
    }
        @Override
	 public String toString() {
	        return "Numero de cuenta:"+NumeroDeCuenta;
	                //To change body of generated methods, choose Tools | Templates.
	    }
	
	 public double Retiro (int cantidadDecrementa )throws SaldoNegativo {
		 	int EsNumero;
		 	String aCadena = String.valueOf(cantidadDecrementa);
		 	EsNumero=validar (aCadena);
		
	    	if ((Saldo< cantidadDecrementa)||(EsNumero==0)) {
	    		throw new SaldoNegativo();
	    	}
	    	 this.Saldo =Saldo - cantidadDecrementa;
	    	
		 	return Saldo;
	    	 
	    }
	 public void setSaldo(int saldo) throws SaldoIncorrecto{
	    	if(saldo < 0) {
	    		throw new SaldoIncorrecto();
	    	}
	        this.Saldo = saldo;
	    }
	 
	 public int validar(String cadena) {
	      if (cadena.matches("[0-9]*")) {
	         return 1;
	      } else {
	         return 0;
	      }
	   }
}
