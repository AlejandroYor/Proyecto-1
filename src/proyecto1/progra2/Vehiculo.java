package proyecto1.progra2;

/**
 *
 * @author Alejandro
 */
public class Vehiculo {

    private String tipo;
    private String placa;
    private double tarifa;

    
    /**
     *  Constructor de objetos Vehiculo
     * @param   tipo   tipo que identifica cada vehiculo
     * @param   placa   placa que identifica cada vehiculo
     * @param   tarifa   tarifa que tiene cada tipo de vehiculo
     */
    public Vehiculo(String tipo, String placa, double tarifa) {
        this.tipo = tipo;
        this.placa = placa;
        this.tarifa = tarifa;
    }
    
    /**
     * Método para consultar el tipo del vehiculo
     * @return  la tipo del vehiculo
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Método para consultar la placa del vehiculo
     * @return  la placa del vehiculo
     */
    public String getPlaca() {
        return placa;
    }
    
    /**
     * Método para consultar la tarifa del vehiculo
     * @return  la tarifa del vehiculo
     */
    public double getTarifa() {
        return tarifa;
    }
    
    /**
     * Método para insertar el tipo del vehiculo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método para insertar la placa del vehiculo
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    /**
     * Método para insertar la tarifa del vehiculo
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    /**
     * Método para llamar al constructor
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "tipo=" + tipo + ", placa=" + placa + ", tarifa=" + tarifa + '}';
    }

}
