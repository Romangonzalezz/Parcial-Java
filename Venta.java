import java.util.ArrayList;
import java.util.Scanner;

public class Venta {

    private Piscina piscina;
    private String nombre;
    private String apellido;

    private MarcaPiscina marca;
    private MarcaPiscina marcaFibra;

    private ColorPiscina color;
    private ColorPiscina colorFibra;
    private int dni;

    private float precio;

    private static ArrayList<Venta> listaVentas = new ArrayList<>();

    public void ingresarVenta() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingresa tu nombre: ");
            nombre = scanner.next();

            System.out.println("Tu apellido: ");
            apellido = scanner.next();

            System.out.println("Tu dni porfavor: ");
            dni = scanner.nextInt();

            System.out.println("Porfavor decime que tipo de piscina vas a comprar: ");
            System.out.println("1) Piscina de cemento");
            System.out.println("2) Piscina de fibra");
            System.out.println("Opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el largo de la piscina en centimetros: ");
                    float largoCemento = scanner.nextFloat();

                    System.out.println("Ingresa el ancho de la piscina en centimetros: ");
                    float anchoCemento = scanner.nextFloat();

                    System.out.println("Ingrese la profundidad de la piscina en centimetros: ");
                    int profundidadCemento = scanner.nextInt();

                    Piscina piscinaCemento = new Piscina();
                    piscinaCemento.datosPiscinaCemento(TipoPiscina.CEMENTO, largoCemento, anchoCemento, profundidadCemento);


                    //MARCA DE PISCINA
                    System.out.println("Elija una marca: (Escribilo tal cual)");
                    //RECORRO EL ENUM MARCA
                    for (MarcaPiscina marca : MarcaPiscina.values()) {
                        System.out.println("- " + marca.name());
                    }
                    //LE ASIGNO A UNA VARIABLE TIPO STRING, LO INGRESADO POR EL USER
                    String marcaElegida = scanner.next().toUpperCase();

                    //OBTIENE LA INSTANCIA DEL VALOR INGRESADO COINCIDENTE
                    marca = MarcaPiscina.valueOf(marcaElegida);

                    //COLOR DE LA PISCINA
                    System.out.println("Elija un color: (Escribilo tal cual)");
                    //RECORRO ...
                    for (ColorPiscina color : ColorPiscina.values()) {
                        System.out.println("- " + color.name());
                    }

                    //ASIGNO LA VARIABLE TIPO STRING, LO INGRESADO POR EL USER
                    String colorElegido = scanner.next().toUpperCase();

                    //OBTIENE LA INSTANCIA DEL VALOR INGRESADO COINCIDENTE
                    color = ColorPiscina.valueOf(colorElegido);

                    System.out.println("Ingrese el precio de la venta en pesos: ");
                    precio = scanner.nextFloat();


                    Venta ventaCemento = new Venta(piscinaCemento, nombre, apellido, dni, precio, color, marca);

                    System.out.println("Su compra fue realizada con exito!!");
                    listaVentas.add(ventaCemento);
                    break;

                case 2:
                    System.out.println("Ingresa el radio de la piscina en metros: ");
                    float radioFibra = scanner.nextFloat();

                    System.out.println("Ingresa la profundidad de la piscina en metros: ");
                    int profundidadFibra = scanner.nextInt();

                    Piscina piscinaFibra = new Piscina();
                    piscinaFibra.datosPiscinaFibra(TipoPiscina.FIBRA, radioFibra, profundidadFibra);

                    System.out.println("Ingresa el precio de la venta en pesos: ");
                    precio = scanner.nextFloat();

                    //MARCA DE PISCINA
                    System.out.println("Elija una marca: (Escribilo tal cual)");

                    //RECORRO EL ENUM MARCA
                    for (MarcaPiscina marcaFibra : MarcaPiscina.values()) {
                        System.out.println("- " + marcaFibra.name());
                    }
                    //LE ASIGNO A UNA VARIABLE TIPO STRING, LO INGRESADO POR EL USER
                    String marcaElegidaFibra = scanner.next().toUpperCase();

                    //OBTIENE LA INSTANCIA DEL VALOR INGRESADO COINCIDENTE
                    marcaFibra = MarcaPiscina.valueOf(marcaElegidaFibra);

                    //COLOR DE LA PISCINA
                    System.out.println("Elija un color: (Escribilo tal cual)");
                    //RECORRO ...
                    for (ColorPiscina colorFibra : ColorPiscina.values()) {
                        System.out.println("- " + colorFibra.name());
                    }

                    //ASIGNO LA VARIABLE TIPO STRING, LO INGRESADO POR EL USER
                    String colorElegidoFibra = scanner.next().toUpperCase();

                    //OBTIENE LA INSTANCIA DEL VALOR INGRESADO COINCIDENTE
                    colorFibra = ColorPiscina.valueOf(colorElegidoFibra);

                    System.out.println("Ingrese el precio de la venta en pesos: ");
                    precio = scanner.nextFloat();


                    Venta ventaFibra = new Venta(piscinaFibra, nombre, apellido, dni, precio, colorFibra, marcaFibra);

                    System.out.println("Su compra fue realizada con exito!!");
                    listaVentas.add(ventaFibra);
                    break;

        }
            } catch (Exception e) {
            System.out.println("Ocurrio un error : " + e);
        }
    }


    public void listarPiletasVendidas() {
        for (Venta venta : listaVentas) {
            Piscina piscina = venta.getPiscina();

            System.out.println();
            System.out.println("Datos de la piscina:");
            if (piscina.getTipo() == TipoPiscina.CEMENTO) {
                System.out.println("Marca: " + venta.getMarca());
            }else {
                System.out.println("Marca: " + venta.getMarcaFibra());
            }

            //Condicional para revisar el tipo de piscina
            if (piscina.getTipo() == TipoPiscina.CEMENTO) {
                System.out.println("Medidas: Largo: " + piscina.getLargo() + " Ancho: " + piscina.getAncho() + " Profundidad: " + piscina.getProfundidad());

            } else if (piscina.getTipo() == TipoPiscina.FIBRA) {
                System.out.println("Radio: " + piscina.getRadio() + " Profundidad: " + piscina.getProfundidad());
            }

            if (piscina.getTipo() == TipoPiscina.CEMENTO) {
                System.out.println("Color: " + venta.getColor());
            }else{
                System.out.println("Color: " + venta.getColorFibra());
            }

            System.out.println("Volumen en centimetros cubicos: " + piscina.calcularVolumen());

            System.out.println("Datos del comprador:");
            System.out.println();

            System.out.println("Nombre: " + venta.getNombre());
            System.out.println("Apellido: " + venta.getApellido());
            System.out.println("DNI: " + venta.getDni());

            System.out.println("----------------------------------------------------------------------");

        }
    }

    public float totalVendidoEnPesos(){
        float contador = 0;

        for(Venta venta : listaVentas){
            contador += venta.getPrecio();
        }

        System.out.println("El total recaudado en pesos es de $" + contador);
        return contador;
    }


    public Venta() {
    }

    public Venta(Piscina piscina, String nombre, String apellido, int dni, float precio, ColorPiscina color, MarcaPiscina marca) {
        this.piscina = piscina;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.precio = precio;
        this.color = color;
        this.marca = marca;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public Piscina getPiscina() {
        return piscina;
    }

    public float getPrecio() {
        return precio;
    }

    public MarcaPiscina getMarca() {
        return marca;
    }

    public MarcaPiscina getMarcaFibra() {
        return marcaFibra;
    }

    public ColorPiscina getColor() {
        return color;
    }

    public ColorPiscina getColorFibra() {
        return colorFibra;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "marca=" + marca +
                ", color=" + color +
                '}';
    }
}