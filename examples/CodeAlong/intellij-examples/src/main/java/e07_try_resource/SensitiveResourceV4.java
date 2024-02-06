package e07_try_resource;

import java.io.Closeable;
import java.io.IOException;

class SensitiveResourceV4 implements Closeable {
    void beforeResourceLock() {
        System.out.println("SensitiveResource2nd.beforeResourceLock()");
    }

    void inResourceLock() {
        System.out.println("SensitiveResource2nd.inResourceLock()");
    }

    @Override
    public void close() throws IOException {
        System.out.println("SensitiveResource2nd.close()");
    }

    public static void main(String[] args) throws IOException {

        SensitiveResourceV4 unit = new SensitiveResourceV4();
        // unit = new SensitiveResourceV4();

        try (unit) {
            unit.inResourceLock();
            System.out.println("2");
        }
        System.out.println(3);
    }
}
