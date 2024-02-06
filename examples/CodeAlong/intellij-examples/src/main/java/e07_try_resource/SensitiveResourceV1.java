package e07_try_resource;

import java.io.IOException;

class SensitiveResourceV1 {
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
    public void close() throws IOException {
        System.out.println("SensitiveResource.criticalSection.close");
    }

    public static void main(String[] args) {

        SensitiveResourceV1 a = null;
        a = new SensitiveResourceV1();
        a.beforeCloseCriticalSection();

        try {
            a.criticalSection();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (a != null) {
                try {
                    a.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
