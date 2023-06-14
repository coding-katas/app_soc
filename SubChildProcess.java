import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SubChildProcess {
    private static final Logger logger = LogManager.getLogger(SubChildProcess.class);

    public static void main(String[] args) {
        logger.info("Hello from the sub-child process!");
        String imageLink = "https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.17.1/log4j-core-2.17.1.jar";
        String wgetCommand = "wget " + imageLink;

        try {
            while (true) {
                Process process = Runtime.getRuntime().exec(wgetCommand);
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    logger.info("Image downloaded successfully!");
                } else {
                    logger.error("Failed to download image. Exit code: " + exitCode);
                }
                Thread.sleep(3  * 60 * 1000); // Sleep for 3 minutes before executing again
            }
        } catch (IOException | InterruptedException e) {
            logger.error("Error occurred while downloading image: " + e.getMessage());
        }
    }
}
