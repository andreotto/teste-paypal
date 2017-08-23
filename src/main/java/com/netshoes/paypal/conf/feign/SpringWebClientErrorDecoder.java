package com.netshoes.paypal.conf.feign;

import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@Component
@Slf4j
public class SpringWebClientErrorDecoder implements ErrorDecoder {

  private ErrorDecoder delegate = new Default();

  @Override
  public Exception decode(final String methodKey, final Response response) {
    HttpStatus statusCode = HttpStatus.valueOf(response.status());

    if (statusCode.is4xxClientError()) {
      log.error(
          "Status Code: {} \n reason: {} \n url: {} method: {}",
          statusCode,
          response.reason(),
          response.request().url(),
          response.request().method());
      return new HttpClientErrorException(
          statusCode, response.reason(), responseHeaders(response), responseBody(response), null);
    }

    return delegate.decode(methodKey, response);
  }

  private HttpHeaders responseHeaders(final Response response) {
    HttpHeaders headers = new HttpHeaders();
    response
        .headers()
        .entrySet()
        .stream()
        .forEach(entry -> headers.put(entry.getKey(), Lists.newArrayList(entry.getValue())));
    return headers;
  }

  private byte[] responseBody(final Response response) {
    try {
      return ByteStreams.toByteArray(response.body().asInputStream());
    } catch (IOException e) {
      throw new HttpMessageNotReadableException("Failed to process response body.", e);
    }
  }
}
