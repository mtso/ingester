package io.mtso;

import org.junit.Assert;
import org.junit.Test;

public class ParserTest {
    @Test
    public void testSpec() {
        String spec = "2: brand";
        String data = "1\t2\tbrand name\t";

        Parser parser = new Parser(spec);
        try {
            ChocolateBar bar = parser.parse(data.split("\t"));
            Assert.assertEquals(bar.getBrand(), "brand name");
        } catch(Exception e) {
            Assert.assertNotEquals(e.toString(), "Spec not set");
        }
    }

    @Test
    public void testParseError() {
        String spec = "2: id";
        String data = "1\t2\tbrand name\t";

        Parser parser = new Parser(spec);
        try {
            ChocolateBar bar = parser.parse(data.split("\t"));
        } catch(Exception e) {
            Assert.assertEquals(e.toString(), "java.lang.NumberFormatException: For input string: \"brand name\"");
        }
    }
}