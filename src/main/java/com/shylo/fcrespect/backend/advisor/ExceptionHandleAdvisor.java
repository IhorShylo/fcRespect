package com.shylo.fcrespect.backend.advisor;

import com.shylo.fcrespect.backend.constants.ProjectConstants;
import com.shylo.fcrespect.backend.constants.ViewConstants;
import com.shylo.fcrespect.backend.controller.ContactsController;
import com.shylo.fcrespect.backend.dto.resp.ErrorResponse;
import com.shylo.fcrespect.backend.dto.resp.ServerErrorResponse;
import com.shylo.fcrespect.backend.dto.resp.ValidationErrorResponse;
import com.shylo.fcrespect.backend.exception.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandleAdvisor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsController.class);

    /*This exception appear during get method arguments validation*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ServerErrorResponse handleGetValidationException(HttpServletRequest request, BindException ex) {
        LOGGER.warn("url - {}, exception during GET request field validation - {}", request.getRequestURL(), ex.getMessage());
        List<ErrorResponse> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(new ValidationErrorResponse(e.getField(), e.getDefaultMessage())));
        return new ServerErrorResponse("exception during GET request field validation", errors);
    }

    /*This exception appear during post method arguments validation*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ServerErrorResponse handlePostValidationException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        LOGGER.warn("url - {}, exception during POST request field validation - {}", request.getRequestURL(), ex.getMessage());
        List<ErrorResponse> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(new ValidationErrorResponse(e.getField(), e.getDefaultMessage())));
        return new ServerErrorResponse("exception during POST request field validation", errors);
    }

    /*This exception appear during file upload*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ServerErrorResponse handleValidationServiceException(HttpServletRequest request, ValidationException ex) {
        LOGGER.error("url - {}, " + ex.getMessage(), request.getRequestURL(), ex);
        return new ServerErrorResponse(ex.getMessage());
    }

    /*Appear when you receive invalid parameter type*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        LOGGER.warn("url - {}, Invalid request parameter type:", request.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ProjectConstants.CONTENT_KEY, ViewConstants.ERROR_404_VIEW);
        modelAndView.setViewName(ProjectConstants.HOME_PAGE_KEY);
        return modelAndView;
    }

    /*This exception appear if we can't find some entity in database*/
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ModelAndView handleEntityNotFoundException(HttpServletRequest request, EntityNotFoundException ex) {
        LOGGER.warn("url - {}, Can't find entity in db:", request.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ProjectConstants.CONTENT_KEY, ViewConstants.ERROR_404_VIEW);
        modelAndView.setViewName(ProjectConstants.HOME_PAGE_KEY);
        return modelAndView;
    }

    /*This exception appear if some method not implemented*/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotImplementedException.class)
    public ModelAndView handleNotImplementedException(HttpServletRequest request, NotImplementedException ex) {
        LOGGER.warn("url - {}, Method not implemented:", request.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ProjectConstants.CONTENT_KEY, ViewConstants.ERROR_500_VIEW);
        modelAndView.setViewName(ProjectConstants.HOME_PAGE_KEY);
        return modelAndView;
    }

    /*This exception appear when we can't save some file*/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StorageException.class)
    @ResponseBody
    public ServerErrorResponse handleStorageException(HttpServletRequest request, StorageException ex) {
        LOGGER.error("url - {}, Error message: {}", request.getRequestURL(), ex.getMessage(), ex);
        return new ServerErrorResponse(ex.getMessage());
    }

    /*All other errors handling*/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllOthersError(HttpServletRequest request, Exception ex) {
        LOGGER.error("url - {}, Unknown error:", request.getRequestURL(), ex);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(ProjectConstants.CONTENT_KEY, ViewConstants.ERROR_500_VIEW);
        modelAndView.setViewName(ProjectConstants.HOME_PAGE_KEY);
        return modelAndView;
    }
}
