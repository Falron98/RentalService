package pl.pjatk.RentalService.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import pl.pjatk.RentalService.Exception.BadRequestException;
import pl.pjatk.RentalService.Exception.InternalServerErrorException;
import pl.pjatk.RentalService.Exception.NotFoundException;

import java.io.IOException;
import java.net.ConnectException;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return new DefaultResponseErrorHandler().hasError(clientHttpResponse);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException
    {
        if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            if (clientHttpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
                throw new InternalServerErrorException();
            }

        } else if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new NotFoundException();
            }
            if (clientHttpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new BadRequestException();
            }

        }

    }
}
