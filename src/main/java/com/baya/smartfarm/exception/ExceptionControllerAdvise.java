package com.baya.smartfarm.exception;//package com.cb.baya.exception;
//
//import com.cb.baya.common.ApiResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
////import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.client.HttpClientErrorException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//@Slf4j
//public class ExceptionControllerAdvise {
//
//
//  @ExceptionHandler(Exception.class)
//  @ResponseBody
//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  public ApiResponse<String> exception(Exception e) {
//    log.error("Processing error:", e);
//    return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//  }
//
//
//  @ExceptionHandler(BusinessException.class)
//  @ResponseBody
//  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//  public ApiResponse<String> exception(BusinessException e) {
//    log.error("Business exception:", e);
//    return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
//  }
//
//  @ExceptionHandler(HttpClientErrorException.class)
//  @ResponseBody
//  @ResponseStatus(HttpStatus.UNAUTHORIZED)
//  public ApiResponse<String> authError(HttpClientErrorException e) {
//    log.error("Auth exception:", e);
//    return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
//  }
//
//  @ExceptionHandler(BadCredentialsException.class)
//  @ResponseBody
//  @ResponseStatus(HttpStatus.UNAUTHORIZED)
//  public ApiResponse<String> authError(BadCredentialsException e) {
//    log.error("Auth exception:", e);
//    return new ApiResponse<>(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
//  }
//
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public Map<String, String> handleValidationExceptions(
//    MethodArgumentNotValidException ex) {
//    Map<String, String> errors = new HashMap<>();
//    ex.getBindingResult().getAllErrors().forEach((error) -> {
//      String fieldName = ((FieldError) error).getField();
//      String errorMessage = error.getDefaultMessage();
//      errors.put(fieldName, errorMessage);
//    });
//    return errors;
//  }
//
//}
