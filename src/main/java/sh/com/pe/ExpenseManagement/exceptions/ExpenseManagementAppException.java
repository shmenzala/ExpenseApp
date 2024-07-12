package sh.com.pe.ExpenseManagement.exceptions;

import org.springframework.http.HttpStatus;

/**
 *
 * @author shmen
 */
public class ExpenseManagementAppException extends RuntimeException {

    private HttpStatus httpStatus;

    public ExpenseManagementAppException() {
    }

    public ExpenseManagementAppException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
