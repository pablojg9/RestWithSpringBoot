package br.com.pablo.rest.controllers;

import br.com.pablo.rest.exceptions.UnsupportedMathOperationException;
import br.com.pablo.rest.utils.MessageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MessageUtil.MESSAGE_EXCEPTION_ERROR_BAD_REQUEST);
        }

        Double sum = converterTwoDouble(numberOne) + converterTwoDouble(numberTwo);

        return sum;
    }

    private Double converterTwoDouble(String strNumber) {

        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);

        return 0D;
    }

    private boolean isNumeric(String strNumber) {

        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
