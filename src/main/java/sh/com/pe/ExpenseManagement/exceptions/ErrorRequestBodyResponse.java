package sh.com.pe.ExpenseManagement.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author shmen
 */
public class ErrorRequestBodyResponse {

    private Map<String, String> fields_errors;
    private LocalDateTime timestamp;
    private String details;

    public ErrorRequestBodyResponse() {
    }

    public ErrorRequestBodyResponse(Map<String, String> fields_errors, LocalDateTime timestamp, String details) {
        this.fields_errors = fields_errors;
        this.timestamp = timestamp;
        this.details = details;
    }

    public Map<String, String> getFields_errors() {
        return fields_errors;
    }

    public void setFields_errors(Map<String, String> fields_errors) {
        this.fields_errors = fields_errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
