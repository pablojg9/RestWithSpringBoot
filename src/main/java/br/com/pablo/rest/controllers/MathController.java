package br.com.pablo.rest.controllers;

import br.com.pablo.rest.exceptions.UnsupportedMathOperationException;
import br.com.pablo.rest.services.MathService;
import br.com.pablo.rest.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MessageUtil.MESSAGE_EXCEPTION_ERROR_BAD_REQUEST);
        }
        return mathService.converterTwoDouble(numberOne) + mathService.converterTwoDouble(numberTwo);

    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MessageUtil.MESSAGE_EXCEPTION_ERROR_BAD_REQUEST);
        }
        return mathService.converterTwoDouble(numberOne) - mathService.converterTwoDouble(numberTwo);
    }


    @RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MessageUtil.MESSAGE_EXCEPTION_ERROR_BAD_REQUEST);
        }
        return mathService.converterTwoDouble(numberOne) * mathService.converterTwoDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MessageUtil.MESSAGE_EXCEPTION_ERROR_BAD_REQUEST);
        }
        return mathService.converterTwoDouble(numberOne) / mathService.converterTwoDouble(numberTwo);
    }
}

