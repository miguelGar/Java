package com.ari.group.excepcion;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExcepcionRequestMapper  implements ExceptionMapper<ExcepcionRequest> {


    @Override
    public Response toResponse(ExcepcionRequest exception) {
        // You can customize the response here
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(exception.getMessage(), exception.getErrorCode()))
                .build();
    }

    // Optional: Custom error response structure
    public static class ErrorResponse {
        private String message;
        private int errorCode;

        public ErrorResponse(String message, int errorCode) {
            this.message = message;
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }
    }
}
