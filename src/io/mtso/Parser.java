package io.mtso;

import java.util.HashMap;

public class Parser {
    private HashMap<String, Integer> spec;

    Parser(String raw) {
        this.spec = new HashMap<String, Integer>();

        String[] fields = raw.split(",");
        for (int i = 0; i < fields.length; i++) {
            String[] pieces = fields[i].trim().split(":");
            if (pieces.length < 2) {
                continue;
            }

            Integer index;
            try {
                index = Integer.parseInt(pieces[0].trim());
                this.spec.put(pieces[1].trim(), index);
            } catch(Exception e) {
                System.out.printf("Error parsing field in spec: %s\n", e);
            }
        }
    }

    public ChocolateBar parse(String[] fields) throws Exception {
        if (this.spec == null) {
            throw new Exception("Spec not set");
        }

        ChocolateBar bar = new ChocolateBar();

        for (String fieldName: this.spec.keySet()) {
            // Match ingester with index.
            Integer index = this.spec.get(fieldName);
            Ingester ingester = bar.getIngester(fieldName);

            ingester.ingest(fields[index]);
        }

        return bar;
    }
}
