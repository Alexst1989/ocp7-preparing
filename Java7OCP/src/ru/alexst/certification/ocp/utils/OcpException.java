package ru.alexst.certification.ocp.utils;

public class OcpException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -6563850633153060256L;

    public OcpException(String message, Throwable e) {
        super(message, e);
    }
    
    public OcpException(String message) {
        super(message);
    }
    
    public OcpException(Throwable e) {
        super(e);
    }
    
    public OcpException() {
        super();
    }
}
