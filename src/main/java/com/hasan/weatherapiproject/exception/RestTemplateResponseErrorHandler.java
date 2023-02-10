package com.hasan.weatherapiproject.exception;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
        || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
        throws IOException{
        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR){
            //Handle SERVER_ERROR
        }else if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR){
            //Handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                throw new AdressNotFoundException(httpResponse.getBody().toString());
            }
        }
    }

}
