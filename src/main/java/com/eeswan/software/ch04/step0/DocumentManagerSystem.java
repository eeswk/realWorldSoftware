package com.eeswan.software.ch04.step0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagerSystem {
    private final Map<String, Import> extensionToImport = new HashMap<>();
    private final List<Document> documents = new ArrayList<>();

    public DocumentManagerSystem() {
        extensionToImport.put("image", new ImageImport());

    }


    public void importFile(final String path) throws IOException {
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf(".");
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new UnknownFileTypeException("No exesion found for file:" + path);
            }

            final String extension = path.substring(separatorIndex + 1);
            final Import importer = extensionToImport.get(extension);
            if (importer == null) {
                throw new UnknownFileTypeException("for file:" + path);
            }

            final Document document = importer.importFile(file);
            documents.add(document);

        } else {
            throw new UnknownFileTypeException("No exesion found for file:" + path);

        }

    }

}

