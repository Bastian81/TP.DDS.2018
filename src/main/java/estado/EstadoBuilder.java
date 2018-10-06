package estado;

public class EstadoBuilder {


    public Estado getStateInstance(int numeroEstado) {
        Estado instanciaEstado;

        switch (numeroEstado){
            case 0 : instanciaEstado = new Apagado();break;
            case 1: instanciaEstado= new Encendido();break;
            case 2: instanciaEstado = new Ahorro();break;
            default:instanciaEstado = new Apagado();break;
        }
       return instanciaEstado;
    }
}
