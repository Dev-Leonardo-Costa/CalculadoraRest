package model;

public class MatematicaSimples {
    
    public Double somar(Double primeiroNumero, Double segundoNumero){
        return primeiroNumero + segundoNumero;
    }

    public Double subtrair(Double primeiroNumero, Double segundoNumero){
        return primeiroNumero - segundoNumero;
    }

    public Double dividir(Double primeiroNumero, Double segundoNumero){
        return primeiroNumero / segundoNumero;
    }

    public Double multiplicar(Double primeiroNumero, Double segundoNumero){
        return primeiroNumero * segundoNumero;
    }

    public Double media(Double notaum, Double notadois, Double notatres){
        Double media = notaum + notadois + notatres;
        Double resultadoNota = media / 3;
        return resultadoNota;
    }

    public Double raizQuadrada(Double numero){
        return (Double) Math.sqrt(numero);
    }
}
