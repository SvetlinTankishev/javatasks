package backend;

public interface LogBackendFactory {
    LogBackend createLogBackend(String classLabel);
}
