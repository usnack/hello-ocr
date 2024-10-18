package io.usnack.hello.tesseract;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

class TesseractApplicationTests {

    @BeforeEach
    void setEnv() {
        System.setProperty("jna.library.path", "/opt/homebrew/Cellar/tesseract/5.4.1_1/lib");
    }

    @Test
    void testTesseract() throws URISyntaxException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/opt/homebrew/share/tessdata/");
        tesseract.setLanguage("eng");

        URL resource = getClass().getClassLoader().getResource("isbn.png");
        File file = new File(resource.toURI());
        String result = tesseract.doOCR(file);

        System.out.println(result);

    }

}
