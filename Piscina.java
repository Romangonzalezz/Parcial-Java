public class Piscina {
    private TipoPiscina tipo;

    private MarcaPiscina marca;

    private ColorPiscina color;
    private float largo;
    private float ancho;

    private float radio;
    private int profundidad;

    public void datosPiscinaCemento(TipoPiscina tipo, float largo, float ancho, int profundidad){
        if (tipo.equals(TipoPiscina.CEMENTO)){
            this.tipo = tipo;
            this.largo = largo;
            this.ancho = ancho;
            this.profundidad = profundidad;

        } else {
            System.out.println("Este metodo, es para cargar datos exclusivamente para las piscinas de cemento.");
        }
    }


    public void datosPiscinaFibra(TipoPiscina tipo, float radio, int profundidad) {
        if (tipo.equals(TipoPiscina.FIBRA)) {
            this.tipo = tipo;
            this.radio = radio;
            this.profundidad = profundidad;

        }else {
            System.out.println("Este metodo, es para cargar datos exclusivamente para las piscinas de fibra.");
        }
    }

    public Piscina() {
    }


    public float calcularVolumen(){
        return largo * ancho * profundidad;
    }



    public TipoPiscina getTipo() {
        return tipo;
    }

    public MarcaPiscina getMarca() {
        return marca;
    }

    public ColorPiscina getColor() {
        return color;
    }

    public float getLargo() {
        return largo;
    }

    public float getAncho() {
        return ancho;
    }

    public float getRadio() {
        return radio;
    }

    public int getProfundidad() {
        return profundidad;
    }


}
