package augurdb;

import java.util.HashMap;
import java.util.Map;

public class AugurDatabase {
    public Map<String, Map<String, Object>> records;
    public Map<String, Map<String, Object>> currentTransaction;

    public AugurDatabase() {
        records = new HashMap<>();
        currentTransaction = null;
    }

    public void startTransaction() {
        if (currentTransaction == null) {
            currentTransaction = new HashMap<>();
        } else {
            throw new RuntimeException("Cannot start a nested transaction.");
        }
    }

    public void commitTransaction() {
        if (currentTransaction == null) {
            throw new RuntimeException("No active transaction.");
        } else {
            for (String objId : currentTransaction.keySet()) {
                Map<String, Object> newValues = currentTransaction.get(objId);
                Map<String, Object> oldValues = records.computeIfAbsent(objId, k -> new HashMap<>());
                oldValues.putAll(newValues);
            }
            currentTransaction = null;
        }
    }

    public void rollbackTransaction() {
        if (currentTransaction == null) {
            throw new RuntimeException("No active transaction.");
        } else {
            currentTransaction = null;
        }
    }

    public void storeField(String objId, String name, Object value) {
        if (currentTransaction == null) {
            throw new RuntimeException("No active transaction.");
        } else {
            Map<String, Object> objRecord = currentTransaction.computeIfAbsent(objId, k -> new HashMap<>());
            objRecord.put(name, value);
        }
    }
}
