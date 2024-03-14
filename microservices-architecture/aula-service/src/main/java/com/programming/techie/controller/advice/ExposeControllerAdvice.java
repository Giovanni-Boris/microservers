package com.programming.techie.controller.advice;

import com.programming.techie.controller.response.ErrorResponse;
import com.programming.techie.controller.response.TipoError;
import com.programming.techie.service.exception.AulaAlreadyTakenExepction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExposeControllerAdvice {

  @ExceptionHandler(value = {AulaAlreadyTakenExepction.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleLimiteCantidadDigitosCuentaException(Exception exception) {

    log.error(this.getClass().getSimpleName(), exception);

    String code = BuilderCodigoError.returnCodigoError(
      DetalleCatalogoError.FUNCTIONAL_PREFIX_ERROR,
      DetalleCatalogoError.NEGOCIO_CHANNEL_PREFIX_ERROR,
      DetalleCatalogoError.EXTERNO_COMPONENT_PREFIX_ERROR,
      DetalleErrorEnum.USER_ALREADY_TAKEN.getCode());

    return buildErrorResponse(TipoError.TipoEnum.FUNCIONAL, code, exception.getMessage());
  }

  private ErrorResponse buildErrorResponse(TipoError.TipoEnum tipo, String code, String message) {
    return ErrorResponse.builder()
      .error(TipoError.builder()
        .tipo(tipo)
        .codigo(code)
        .mensaje(message)
        .build()
      ).build();
  }
}