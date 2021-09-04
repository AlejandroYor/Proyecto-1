package proyecto1.progra2;

/**
 *
 * @author Alejandro
 */
public class Moto extends Vehiculo {

    public Moto(String tipo, String placa, double tarifa) {
        super(tipo, placa, tarifa);
    }

    @Override
    public double getTarifa() {
        return super.getTarifa() + super.getTarifa() * 0.10;
    }
}
