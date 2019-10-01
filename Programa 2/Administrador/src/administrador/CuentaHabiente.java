

public class CuentaHabiente extends Persona{
	
	int NumerodeCliente;
	
	public CuentaHabiente (int Num,String Nombre) {
		this.NumerodeCliente=Num;
		this.nombre=Nombre;
	}
	
	@Override
    public String toString() {
        return "["+nombre+","+NumerodeCliente+"]";
                //To change body of generated methods, choose Tools | Templates.
    }
}
