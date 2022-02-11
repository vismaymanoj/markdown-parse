import static org.junit.Assert.*; // import external method
import org.junit.*; // import junit

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class MarkdownParseTest { // create a tester class
    @Test // declare it as a test 
    public void addition() { //create the addition tester method
        assertEquals(2, 1 + 1); // tests for equality of addition using junit built in testing method assertEquals
    }

    @Test
    public void testGetLinks() throws IOException{
        String[] args = {"test-file.md"};
        Path file = Path.of(args[0]);
        String fileContent = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("[https://something.com, some-page.html]", links.toString());
    }

    @Test
    public void testGetLinks2() throws IOException{
        String[] args = {"newFile.md"};
        Path file = Path.of(args[0]);
        String fileContent = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("[https://ucsd-cse15l-w22.github.io/week/week3/, https://www.youtube.com/]", links.toString());
    }

    @Test
    public void testGetLinks3() throws IOException{
        String[] args = {"newFile2.md"};
        Path file = Path.of(args[0]);
        String fileContent = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("[www.123.com]", links.toString());
    }
}