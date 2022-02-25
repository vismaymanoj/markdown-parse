import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testMissingCloseParen() {
        String contents= "[link title](a.com";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceAroundLink() {
        String contents= "[link title](   a.com   )";
        List<String> expect = List.of("a.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }


    @Test
    public void links5() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        output.add("url.com");
        output.add("`google.com");
        output.add("google.com");
        output.add("ucsd.edu");
        String real = "test-file5.md";
        Path fileName = Path.of(real);
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(output, links);
    }
}   