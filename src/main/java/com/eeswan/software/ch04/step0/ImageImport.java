package com.eeswan.software.ch04.step0;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import static com.eeswan.software.ch04.step0.Attributes.HEIGHT;
import static com.eeswan.software.ch04.step0.Attributes.PATH;
import static com.eeswan.software.ch04.step0.Attributes.TYPE;
import static com.eeswan.software.ch04.step0.Attributes.WIDTH;

public class ImageImport implements Import {

    @Override
    public Document importFile(final File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        attributes.put(PATH, file.getPath());
        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "IMAGE");
        return new Document(attributes);

    }

}
