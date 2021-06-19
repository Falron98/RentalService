package pl.pjatk.RentalService.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.RentalService.Exception.BadRequestException;
import pl.pjatk.RentalService.Exception.ConnectException;
import pl.pjatk.RentalService.Exception.InternalServerErrorException;
import pl.pjatk.RentalService.Exception.NotFoundException;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Void> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Void> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<Void> handleInternalServerErrorException
            (InternalServerErrorException exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    @ExceptionHandler(value = ConnectException.class)
    public ResponseEntity<Void> handleConnectException
            (ConnectException exception) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).build();
    }
}
