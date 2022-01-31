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
