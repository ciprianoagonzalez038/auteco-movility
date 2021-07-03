package com.auteco.msnumber.models;

/**
 *
 * @author Cipriano Armando Gonzalez Ramirez <ciprianoagonzalez038@gmail.com>
 */
public class ApiResponse {
    
     private final String codigo;
    private final String mensaje;
    private final Object data;

    private ApiResponse(error builder) {
        this.codigo = builder.codigo;
        this.mensaje = builder.mensaje;
        this.data = builder.data;
    }

    private ApiResponse(ok builder) {
        this.codigo = (builder.codigo==null?"000":builder.codigo);
        this.mensaje = (builder.mensaje==null?"OK":builder.mensaje);
        this.data = builder.data;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Object getData() {
        return data;
    }

    public static class ok {

        private String codigo;
        private String mensaje;
        private Object data;

        public ok data(Object data) {
            this.codigo = "000";
            this.mensaje = "OK";
            this.data = data;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }

    public static class error {

        private String codigo;
        private String mensaje;
        private Object data;

        public error data(Object data) {
            this.codigo = "001";
            this.data = data;
            return this;
        }

        public error mensaje(String mensaje) {
            this.mensaje = mensaje;
            this.codigo = "001";
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }
}
