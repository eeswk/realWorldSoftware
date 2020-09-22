package com.eeswan.software.ch04.step0;

import java.io.File;
import java.io.IOException;


public interface Import {


    Document importFile(File file) throws IOException;
}
