package br.com.calculadorarest.controllers;

import br.com.calculadorarest.exceptions.OperacaoMatematicaNaoSuportada;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatematicaController {

    @RequestMapping(value = "/somar/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double soma(@PathVariable("primeiroNumero") String primeiroNumero, @PathVariable("segundoNumero") String segundoNumero) throws Exception {
        if (!eNumerico(primeiroNumero) || !eNumerico(segundoNumero)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        Double soma = coverterDouble(primeiroNumero) + coverterDouble(segundoNumero);
        return soma;
    }

    @RequestMapping(value = "/dividir/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double divisao(@PathVariable("primeiroNumero") String primeiroNumero, @PathVariable("segundoNumero") String segundoNumero) throws Exception {
        if (!eNumerico(primeiroNumero) || !eNumerico(segundoNumero)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        Double dividi = coverterDouble(primeiroNumero) / coverterDouble(segundoNumero);
        return dividi;
    }

    @RequestMapping(value = "/multiplicar/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable("primeiroNumero") String primeiroNumero, @PathVariable("segundoNumero") String segundoNumero) throws Exception {
        if (!eNumerico(primeiroNumero) || !eNumerico(segundoNumero)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        Double multiplica = coverterDouble(primeiroNumero) * coverterDouble(segundoNumero);
        return multiplica;
    }

    @RequestMapping(value = "/subtrair/{primeiroNumero}/{segundoNumero}", method = RequestMethod.GET)
    public Double subtracao(@PathVariable("primeiroNumero") String primeiroNumero, @PathVariable("segundoNumero") String segundoNumero) throws Exception {
        if (!eNumerico(primeiroNumero) || !eNumerico(segundoNumero)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        Double subtrai = coverterDouble(primeiroNumero) - coverterDouble(segundoNumero);
        return subtrai;
    }

    @RequestMapping(value = "/media/{notaum}/{notadois}/{notatres}", method = RequestMethod.GET)
    public Double media(@PathVariable("notaum") String notaum, @PathVariable("notadois") String notadois, @PathVariable("notatres") String notatres) throws Exception {
        if (!eNumerico(notaum) || !eNumerico(notadois) || !eNumerico(notatres)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        Double media = coverterDouble(notaum) + coverterDouble(notadois) + coverterDouble(notatres);
        Double resultadoMedia = media / 3;
        return resultadoMedia;
    }

    @RequestMapping(value = "/raiz/{numero}", method = RequestMethod.GET)
    public Double raizQuadrada(@PathVariable("numero") String numero) throws Exception {
        if (!eNumerico(numero)) {
            throw new OperacaoMatematicaNaoSuportada("favor defina um valor numerico!");
        }
        return Math.sqrt(coverterDouble(numero));
    }

    private Double coverterDouble(String strNumero) {
        if (strNumero == null) return 0D;
        String numero = strNumero.replaceAll(",",".");
        if (eNumerico(numero)) return  Double.parseDouble(numero);
        return 0D;
    }

    private boolean eNumerico(String strNumero) {
        if (strNumero == null) return false;
        String numero = strNumero.replaceAll(",",".");
        return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
