package br.com.calculadorarest.servico;

public class MatematicaService {

    public Double somar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public Double subtrair(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero - segundoNumero;
    }

    public Double dividir(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero / segundoNumero;
    }

    public Double multiplicar(Double primeiroNumero, Double segundoNumero) {
        return primeiroNumero * segundoNumero;
    }

    public Double media(Double notaum, Double notadois, Double notatres) {
        Double media = (notaum + notadois + notatres) / 2;
        return media;
    }

    public Double raizQuadrada(Double numero) {
        return (Double) Math.sqrt(numero);
    }
}
