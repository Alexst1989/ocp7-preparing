package ru.alexst.certification.ocp.utils;

public class OcpRuntimeException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -1936096111930459102L;

    
    public OcpRuntimeException(String message, Throwable e) {
        super(message, e);
    }
    
    public OcpRuntimeException(String message) {
        super(message);
    }
    
    public OcpRuntimeException(Throwable e) {
        super(e);
    }
    
    public OcpRuntimeException() {
        super();
    }
}
