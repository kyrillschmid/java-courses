package e07_try_resource;

import java.io.Closeable;
import java.io.IOException;

/*class SensitiveResourceV2 implements Closeable {

    void beforeCloseCriticalSection() {
        System.out.println("SensitiveResource.beforeCloseCriticalSection");
    }

    private void sensitive() {
        System.out.println("SensitiveResource.sensitive");
    }

    public void criticalSection() {
        System.out.println("SensitiveResource.criticalSection.resourceCriticalActivity");
        this.sensitive();
    }

    @Override
    public void close() throws IOException {
        System.out.println("SensitiveResource.criticalSection.close");
    }

    public static void main(String[] args) throws IOException {

        // we cannot use SensitiveResource before we declared it in try
        SensitiveResourceV2 a = new SensitiveResourceV2();
        a.beforeCloseCriticalSection();

        try (SensitiveResourceV2 a = new SensitiveResourceV2()) {
            a.beforeCloseCriticalSection();
            a.criticalSection();
        }
    }
}*/
