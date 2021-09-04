package proyecto1.progra2;

//Librerias utilizadas
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alejandro y Kathy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Scanner entrada = new Scanner(System.in);

        //Objetos
        ArrayList<Carro> ListaCarros = new ArrayList<Carro>();
        ArrayList<Moto> ListaMotos = new ArrayList<Moto>();
        ArrayList<Camion> ListaCamiones = new ArrayList<Camion>();

        //Variables
        int cerrar = 0;
        int conteoCarro = 1, conteoMoto = 1, conteoCamion = 1;
        int espacioCarro = 0, espacioMoto = 0, espacioCamion = 0;

        //Datos generales a ingresar para hacer calculos mas adelante
        System.out.println("*** INGRESE DATOS GENERALES ***");
        System.out.println(" ");
        System.out.println("Cuantos parqueos totales hay para carros?");
        espacioCarro = entrada.nextInt();
        System.out.println("Cual es la tarifa para los carros?");
        double tarifaCarros = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Cuantos parqueos totales hay para motos?");
        espacioMoto = entrada.nextInt();
        System.out.println("Cual es la tarifa para las motos?");
        double tarifaMotos = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Cuantos parqueos totales hay para camiones?");
        espacioCamion = entrada.nextInt();
        System.out.println("Cual es la tarifa para los camiones?");
        double tarifaCamion = entrada.nextDouble();
        entrada.nextLine();

        //MENU
        do {
            System.out.println("*** BIENVENIDO AL PARQUEO DON PEPE ***");    
            System.out.println("*** CARROS ***");
            System.out.println("1. Ingresar carro");
            System.out.println("2. Sacar carro");
            System.out.println("*** MOTOS ***");
            System.out.println("3. Ingresar moto");
            System.out.println("4. Sacar moto");
            System.out.println("*** CAMIONES ***");
            System.out.println("5. Ingresar camion");
            System.out.println("6. Sacar camion");

            //Variables que quiero que se inicialicen al tomar el ciclo
            int tiempoCarro = 0, tiempoMoto = 0, tiempoCamion = 0;
            String placa = "";
            int eliminarCarro = 0, eliminarMoto = 0, eliminarCamion = 0;
            double calculoTarifaCarro = 0, calculoTarifaMoto = 0, calculoTarifaCamion = 0;

            //Elegir opcion del menu
            System.out.print("Ingrese la opcion deseada: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    // INGRESO DE CARROS
                    if (espacioCarro >= conteoCarro) {  //Condicion para solo ingresar carros si hay espacio disponible
                        System.out.println("Ingresando carro al parqueo...");
                        System.out.println("Ingrese placa:");
                        placa = entrada.nextLine();
                        ListaCarros.add(new Carro("Carro", placa, tarifaCarros)); //Ingresando carro al objeto
                        System.out.println("Espacio ocupado... " + ListaCarros.size() + " de " + espacioCarro);
                        System.out.println(ListaCarros);
                        conteoCarro++; //Conteo para llevar la cuenta de los espacios que se lleva
                        break;
                    } else {
                        System.out.println("No hay mas espacio en el parqueo");
                        break;
                    }

                case 2:
                    //SALIDA DE CARROS
                    System.out.println("tiempo en segundos tardados: ");
                    tiempoCarro = entrada.nextInt();
                    calculoTarifaCarro =  tiempoCarro / 10 * tarifaCarros;  //Calculo para sacar la cuenta total
                    System.out.println("Debe de pagar: Q" + calculoTarifaCarro);
                    System.out.println("Ingrese el NO. de parqueo: ");
                    eliminarCarro = entrada.nextInt();  //Ingresando el numero de parqueo
                    ListaCarros.remove(eliminarCarro);  //Eliminando carro del parqueo
                    System.out.println(ListaCarros);    //Mostrando los carros que hay en la lista
                    conteoCarro--;  //Conteo para eliminar un espacio del parqueo
                    break;

                case 3:
                    //INGRESO DE MOTOS
                    if (espacioMoto >= conteoMoto) { //Condicion para solo ingresar motos si hay espacio disponible
                        System.out.println("Ingresando moto al parqueo...");
                        System.out.println("Ingrese placa:");
                        placa = entrada.nextLine();
                        ListaMotos.add(new Moto("Moto", placa, tarifaMotos)); //Ingresando moto al objeto
                        System.out.println("Espacio ocupado... " + ListaMotos.size() + " de " + espacioMoto);
                        System.out.println(ListaMotos);
                        conteoMoto++;   //Conteo para llevar la cuenta de los espacios que se lleva.
                        break;
                    } else {
                        System.out.println("No hay mas espacio en el parqueo");
                        break;
                    }

                case 4:
                    //SALIDA DE MOTOS
                    System.out.println("tiempo en segundos tardados: ");
                    tiempoMoto = entrada.nextInt();
                    calculoTarifaMoto = (tiempoMoto / 10 * tarifaMotos) - ((tiempoMoto / 10 * tarifaMotos) * 0.10); //Calculo para sacar la cuenta total
                    System.out.println("Debe de pagar: Q" + calculoTarifaMoto);
                    System.out.println("Ingrese el NO. de parqueo: ");
                    eliminarMoto = entrada.nextInt();   //Ingresando el numero de parqueo
                    ListaMotos.remove(eliminarMoto);    //Eliminando moto del parqueo
                    System.out.println(ListaMotos);     //Mostrando las motos que hay en la lista
                    conteoMoto--;   //Conteo para eliminar un espacio del parqueo
                    break;

                case 5:
                    //INGRESO DE CAMIONES
                    if (espacioCamion >= conteoCamion) { //Condicion para solo ingresar camiones si hay espacio disponible
                        System.out.println("Ingresando camion al parqueo...");
                        System.out.println("Ingrese placa:");
                        placa = entrada.nextLine();
                        ListaCamiones.add(new Camion("Camion", placa, tarifaCamion));   //Ingresando camion al objeto
                        System.out.println("Espacio ocupado... " + ListaCamiones.size() + " de " + espacioCamion);
                        System.out.println(ListaCamiones);
                        conteoCamion++; //Conteo para llevar la cuenta de los espacios que se lleva.
                        break;
                    } else {
                        System.out.println("No hay mas espacio en el parqueo");
                        break;
                    }

                case 6:
                    //SALIDA DE CAMIONES
                    System.out.println("tiempo en segundos tardados: ");
                    tiempoCamion = entrada.nextInt();
                    calculoTarifaCamion = (2 * tarifaCamion)+ (tiempoCamion / 5);
                    System.out.println("Debe de pagar: Q" + calculoTarifaCamion); //Calculo para sacar la cuenta total
                    System.out.println("Ingrese el NO. de parqueo: ");
                    eliminarCamion = entrada.nextInt();     //Ingresando el numero de parqueo
                    ListaCamiones.remove(eliminarCamion);   //Eliminando camion del parqueo
                    System.out.println(ListaCamiones);      //Mostrando los camiones que hay en la lista
                    conteoCamion--; //Conteo para eliminar un espacio del parqueo
                    break;
            }
            // LLAMADA AL METODO PARA CREAR EL PDF
            crearPDFCARROS(ListaCarros);
            crearPDFMOTOS(ListaMotos);
            crearPDFCAMION(ListaCamiones);

            //menu para ver si desea salir o repetir
            System.out.println(" ");
            System.out.println("Desea salir?");
            System.out.println("1) Si");
            System.out.println("2) No");
            cerrar = entrada.nextInt();

        } while (cerrar == 2);  //Cilo para repetir todo

    }

    /**
     * Método para crear los pdf de los carros
     */
    public static void crearPDFCARROS(List<Carro> lista) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("CARROS.pdf");

        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);

        // Se abre el documento
        documento.open();

        // Parrafo
        Paragraph titulo = new Paragraph("Ticket con datos de parqueo \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                )
        );

        // Añadimos el titulo al documento
        documento.add(titulo);

        // Creamos una tabla
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("PARQUEO");
        tabla.addCell("PLACA");
        tabla.addCell("TIPO");

        for (int i = 0; i < lista.size(); i++) {
            tabla.addCell("" + i);
            tabla.addCell(lista.get(i).getPlaca());
            tabla.addCell(lista.get(i).getTipo());
        }

        // Añadimos la tabla al documento
        documento.add(tabla);

        // Se cierra el documento
        documento.close();
    }

    /**
     * Método para crear los pdf de las motos
     */
    public static void crearPDFMOTOS(List<Moto> lista) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("MOTOS.pdf");

        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);

        // Se abre el documento
        documento.open();

        // Parrafo
        Paragraph titulo = new Paragraph("Ticket con datos de parqueo \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                )
        );

        // Añadimos el titulo al documento
        documento.add(titulo);

        // Creamos una tabla
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("PARQUEO");
        tabla.addCell("PLACA");
        tabla.addCell("TIPO");

        for (int i = 0; i < lista.size(); i++) {
            tabla.addCell("" + i);
            tabla.addCell(lista.get(i).getPlaca());
            tabla.addCell(lista.get(i).getTipo());
        }

        // Añadimos la tabla al documento
        documento.add(tabla);

        // Se cierra el documento
        documento.close();
    }

    /**
     * Método para crear los pdf de los camiones
     */
    public static void crearPDFCAMION(List<Camion> lista) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();

        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream("CAMIONES.pdf");

        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);

        // Se abre el documento
        documento.open();

        // Parrafo
        Paragraph titulo = new Paragraph("Ticket con datos de parqueo \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                )
        );

        // Añadimos el titulo al documento
        documento.add(titulo);

        // Creamos una tabla
        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("PARQUEO");
        tabla.addCell("PLACA");
        tabla.addCell("TIPO");

        for (int i = 0; i < lista.size(); i++) {
            tabla.addCell("" + i);
            tabla.addCell(lista.get(i).getPlaca());
            tabla.addCell(lista.get(i).getTipo());
        }

        // Añadimos la tabla al documento
        documento.add(tabla);

        // Se cierra el documento
        documento.close();
    }

}
