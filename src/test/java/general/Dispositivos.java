package general;

public class Dispositivos {
	
	   private String nombre;
	    private Float consumo;
	    private Boolean estado;

	    public Dispositivos(String nombre, Float consumo, Boolean estado) 
	    {
	        this.nombre = nombre;
	        this.consumo = consumo;
	        this.estado = estado;
	    }
	    
	    
	    public String getNombre() {return nombre;}
	    public Float getConsumo() {return consumo;}
	    public Boolean estaEncendido() {return estado;}
	   
	
	    // Para cambiar estado del dispositivo 
	    public void estado(Boolean nuevoEstado) {estado = nuevoEstado;}
	    
	   

}
