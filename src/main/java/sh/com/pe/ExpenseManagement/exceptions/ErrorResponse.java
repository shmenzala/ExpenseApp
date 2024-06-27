/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sh.com.pe.ExpenseManagement.exceptions;

import java.time.LocalDateTime;

/**
 *
 * @author shmen
 */
public class ErrorResponse {

    private String message;
    private LocalDateTime timestamp;
    private String details;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, LocalDateTime timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
