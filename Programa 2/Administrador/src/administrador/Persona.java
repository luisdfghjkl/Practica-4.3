

public class Persona {
	
	int edad;
    String nombre;

    private int estatura = 170;

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }
    public Persona(String nombre){
        this.nombre=nombre;
        edad=20;
    }
    public Persona() {
        edad=20;
        nombre="Abundio";
    }
   public void saludar(){
        System.out.println("Hola, soy "+nombre+" y tengo "+edad+
                " anios");
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //sobreescribimos el metodo equals heredado de Object
    //para usar criterios de comparacion propios de Persona
    @Override
    public boolean equals(Object o){
        //tenemos que comparar este objecto, contra el objeto o
        //lo primero que tenemos que verificar es que o sea
        //del mismo tipo que este objeto
        //para eso podemos utilizar el operador instanceof
        if(o instanceof Persona){
            //o y this si se pueden comparar por que ambos son
            //Personas
            //ahora verificamos si sus atributos son los
            //mismos
            //primero almacenamos o en una variable de tipo
            //persona para poder tener acceso a los atributos
            Persona p=(Persona)o;//hacemos casting explicito
            if(this.nombre.equals(p.nombre)&&this.edad==p.edad&&
                    this.estatura==p.estatura){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "["+nombre+"]";
                //To change body of generated methods, choose Tools | Templates.
    }
    
	
}
