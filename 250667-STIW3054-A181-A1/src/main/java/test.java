

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

    public static List<table> TestData() throws IOException {
            List<table> result = new ArrayList<table>();
            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
            Elements trs = doc.select("table[class=wikitable]");
            Element row = trs.get(1);
            for (int i = 0; i <= 23; i++) {
                String theader = row.select("th").get(i).text();
                String tdata = row.select("td").get(i).text();
                result.add(new table(theader, tdata));
            }
            return result;
    }
}

