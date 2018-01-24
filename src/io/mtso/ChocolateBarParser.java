package io.mtso;

public class ChocolateBarParser extends Spec implements Parser<ChocolateBar> {
    ChocolateBarParser(String spec) {
        super(spec);
    }

    public ChocolateBar parse(String[] fields) {
        ChocolateBar bar = new ChocolateBar();

        for (String fieldName: this.keySet()) {
            // Match ingester with index.
            Integer index = this.get(fieldName);
            Ingester ingester = bar.getIngester(fieldName);

            ingester.ingest(fields[index]);
        }

        return bar;
    }
}
