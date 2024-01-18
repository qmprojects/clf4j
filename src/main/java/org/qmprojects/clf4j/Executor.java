package org.qmprojects.clf4j;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author woz07
 * @date 18/1/2024
 * Executor.java
 * What needs to be initialized in order to use the library.
 */

public class Executor {
    private final ProcessBuilder builder;

    /**
     * @author woz07
     * @date 18/1/2024
     * Default constructor
     */
    public Executor() {
        builder = new ProcessBuilder();
    }

    /**
     * @author woz07
     * @date 18/1/2024
     * @param file The file you want executed
     * @param args The args you want to include
     * @param lang The target language you want to execute
     * @return The response code
     * @throws IOException Thrown because of ProcessBuilder.start();
     * @throws InterruptedException Thrown because of Process.waitFor();
     */
    public int execute(File file, String[] args, Lang lang) throws IOException, InterruptedException {
        builder.command(lang.getCommand() + String.join(Arrays.toString(args), ", "));
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        return builder.start().waitFor();
    }
}