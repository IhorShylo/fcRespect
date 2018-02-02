package com.shylo.fcrespect.backend.advisor;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.controller.ContactsController;
import com.shylo.fcrespect.backend.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandleAdvisor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);

    /*This exception appear during get method arguments validation*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public List<ErrorResponse> handleGetValidationException(HttpServletRequest request, BindException ex) {
        LOGGER.error("url - {}, exception - {}", request.getRequestURL(), ex.getMessage());
        List<ErrorResponse> result = new ArrayList<>();
        ex.getFieldErrors().forEach(e -> result.add(new ErrorResponse(e.getField(), e.getDefaultMessage())));
        return result;
    }

    /*This exception appear during post method arguments validation*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<ErrorResponse> defaultErrorHandle(HttpServletRequest request, MethodArgumentNotValidException ex) {
        LOGGER.error("url - {}, exception - {}", request.getRequestURL(), ex.getMessage());
        List<ErrorResponse> result = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> result.add(new ErrorResponse(e.getField(), e.getDefaultMessage())));
        return result;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllOthersError(HttpServletRequest request, Exception ex) {
        LOGGER.error("url - {}, exception:", request.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ProjectConstants.CONTENT_KEY, ViewConstants.ERROR_500_VIEW);
        modelAndView.setViewName(ProjectConstants.HOME_PAGE_KEY);
        return modelAndView;
    }
}
