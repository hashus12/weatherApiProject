package com.hasan.weatherapiproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
        || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    // The method where we make our own exception handler.
    @Override
    public void handleError(ClientHttpResponse httpResponse)
        throws IOException{
        System.out.println(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR){
            //Handle SERVER_ERROR
        }else if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR){
            //Handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new AdressTimeNotFoundException("address and time should not be empty.");
            } else if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new BadRequestException("incorrect address or time");
            }
        }
    }

}
