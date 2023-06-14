import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildProcess {
    private static final Logger logger = LogManager.getLogger(ChildProcess.class);

    public static void main(String[] args) {
        logger.info("Hello from the child process!");

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "SubChildProcess");
            Process subChildProcess = pb.start();
            subChildProcess.waitFor();
        } catch (Exception e) {
            logger.error("Error running sub-child process", e);
        }
    }
}
