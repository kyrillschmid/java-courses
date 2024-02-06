package e07_try_resource;

import java.io.Closeable;
import java.io.IOException;

/*class SensitiveResourceV3 {
    void beforeCloseCriticalSection() {
        System.out.println("SensitiveResource.beforeCloseCriticalSection");
    }
    private void sensitive() {
        System.out.println("SensitiveResource.sensitive");
    }
    Closeable criticalSection() {
        return new CriticalSectionHandler(this);
    }
    class CriticalSectionHandler implements Closeable {
        private final SensitiveResourceV3 sensitiveResource;
        public CriticalSectionHandler(SensitiveResourceV3 sensitiveResource) {
            this.sensitiveResource = sensitiveResource;
        }
        void resourceCriticalActivity() {
            System.out.println("SensitiveResource.criticalSection.resourceCriticalActivity");
            sensitiveResource.sensitive();
        }
        @Override
        public void close() throws IOException {
            System.out.println("SensitiveResource.criticalSection.close");
        }
    }

    public static void main(String[] args) throws IOException {
        SensitiveResourceV3 a = new SensitiveResourceV3();
        a.beforeCloseCriticalSection();

        try (CriticalSectionHandler criticalSection = (SensitiveResourceV3.CriticalSectionHandler) a.criticalSection()) {
            criticalSection.resourceCriticalActivity();
        }
    }
}*/
