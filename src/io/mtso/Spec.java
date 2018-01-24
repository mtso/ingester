package io.mtso;

import java.util.HashMap;

public class Spec extends HashMap<String, Integer> {

    Spec(String raw) {
        super();

        String[] fields = raw.split(",");
        for (int i = 0; i < fields.length; i++) {
            String[] pieces = fields[i].trim().split(":");
            if (pieces.length < 2) {
                continue;
            }

            Integer index;
            try {
                index = Integer.parseInt(pieces[0].trim());

                this.put(pieces[1].trim(), index);
            } catch(Exception e) {
                System.out.printf("Error parsing field in spec: %s\n", e);
                throw e;
            }
        }
    }
}
