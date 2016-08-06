package ru.alexst.certification.ocp.par7.assertionsexceptions;

import java.io.Closeable;
import java.io.IOException;

import ru.alexst.certification.ocp.utils.OcpException;
import ru.alexst.certification.ocp.utils.OcpRuntimeException;

public class TryWithResource2 {
    static class Bird implements AutoCloseable {
        @Override
        public void close() throws OcpException {
            throw new OcpRuntimeException("a");
        }
    }
    
    static class Ball implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("2");
            throw new OcpRuntimeException("b");
        }
    }
    
    public static void main(String args[]) throws OcpException, IOException {
        new TryWithResource2().run();
    }
    
    void run() throws OcpException, IOException {
        try (Ball bird = new Ball()) {
            System.out.println("1");
            throw new OcpException();
        } catch (OcpException e) {
            System.out.println("3");
            throw e;
        } finally {
            System.out.println("4");        
        }
    }
}
