package ru.alexst.certification.ocp.par7.assertionsexceptions;

import ru.alexst.certification.ocp.utils.OcpException;

public class TryWithResource2 {
    static class Bird implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new RuntimeException("a");
        }
    }
    
    static class Ball implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new OcpException();
        }
    }
}
