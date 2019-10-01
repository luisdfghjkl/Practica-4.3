

public class Banco extends CuentadeCheques{
	
	
	    public Banco(int Num) {
		super(Num);
		// TODO Auto-generated constructor stub
	}

		
		double saldo;
		
	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) throws SaldoIncorrecto{
	    	if(saldo < 0) {
	    		throw new SaldoIncorrecto();
	    	}
	        this.saldo = saldo;
	    }

	  
	    public void Transferencia (double dinero,Banco destino ) throws SaldoNegativo {
	    	
	    	if (saldo< dinero) {
	    		throw new SaldoNegativo();
	    	}
	    	saldo= saldo- dinero;
	    	destino.Deposito(dinero);
	    
	    	
	    	
	    }
	    
	    public double Retiro (double cantidadDecrementa )throws SaldoNegativo {
	    	if (saldo< cantidadDecrementa) {
	    		throw new SaldoNegativo();
	    	}
	    	 this.saldo =saldo - cantidadDecrementa;
	    	 return saldo;
	    }
	    
	   public double Deposito (double dinero) throws SaldoNegativo{
		   if (dinero < 0) {
			   throw new SaldoNegativo();
		   }
		   this.saldo =saldo +dinero;
		   return saldo;
		   
	   }    
	 
	   
	  
	 //   @Override
	   // public String toString() {
	    	
	    //	return "Soy : "+nombre+" mi numero de cuenta es  "+NumeroDeCuenta+"mi saldo es: "+ saldo+" pesos.";
	    	
	   // }
	}