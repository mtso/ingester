package io.mtso;

public class Main {
    static final String spec = "0: id, 1: brand, 2: name, 3: origin, 4: percentage";

    public static void main(String[] args) {
        String data = "1\tRaaka\tCoconut Milk\tDominican Republic\t60\n" +
                "2\tRogue\tTranquilidad\tBolivia\t75\n" +
                "3\tRogue\tLa Masica\tHonduras\t75\n" +
                "4\tRogue\tEsmeraldas\tEcuador\t80\n" +
                "5\tRaaka\tVirgin Chocolate\tChile\t70\n" +
                "6\tRaaka\tMaple & Nibs\tBolivia\t75\n" +
                "7\tRaaka\tVanilla Rooibos\tDominican Republic & Bolivia\t67";

        Parser<ChocolateBar> parser = new ChocolateBarParser(spec);

        try {
            for (String line: data.split("\n")) {
                String[] fields = line.trim().split("\t");

                ChocolateBar bar = parser.parse(fields);
                System.out.println(bar.toString());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
