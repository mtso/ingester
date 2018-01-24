package io.mtso;

import java.util.HashMap;

public class ChocolateBar {
    private Integer id;
    private String brand;
    private String name;
    private String origin;
    private Double percentage;

    private HashMap<String, Ingester> ingesters;

    ChocolateBar() {
        this.ingesters = new HashMap<>();

        // Register ingester functions by column name.

        ingesters.put("brand", (String brand) -> this.setBrand(brand));
        ingesters.put("name", (String name) -> this.setName(name));
        ingesters.put("origin", (String origin) -> this.setOrigin(origin));

        ingesters.put("id", (String value) -> {
            try {
                Integer id = Integer.parseInt(value);
                this.setId(id);
            } catch(Exception e) {
                System.out.println(e);
                throw e;
            }
        });

        ingesters.put("percentage", (String value) -> {
            try {
                Double percentage = Double.parseDouble(value);
                this.setPercentage(percentage);
            } catch(Exception e) {
                System.out.println(e);
                throw e;
            }
        });
    }

    public Integer getId() { return this.id; }
    public String getBrand() { return this.brand; }
    public String getName() { return this.name; }
    public String getOrigin() { return this.origin; }
    public Double getPercentage() { return this.percentage; }

    public void setId(Integer id) { this.id = id; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setName(String name) { this.name = name; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }

    public String toString() {
        return String.format(
                "%d: %s's %s (%f%%) from %s",
                this.id,
                this.brand,
                this.name,
                this.percentage,
                this.origin
        );
    }

    public Ingester getIngester(String fieldName) {
        return this.ingesters.getOrDefault(fieldName, (String unrecognizedName) -> {
            System.out.printf("Unrecognized field name: [%s]\n", unrecognizedName);
        });
    }
}
