package cli;

import org.junit.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CliTest {
    @Test
    public void picoTest() {
        String[] args = {
                "-d", "src/test/resources/phone-calls/dataConfig.json",
                "-p", "src/test/resources/phone-calls/processorConfig.json",
                "-m", "src/test/resources/phone-calls/migrationStatus.json",
                "-s", "src/test/resources/phone-calls/schema.gql",
                "-k", "grami_cli_test",
                "-g", "127.0.0.1:48555",
                "-cm"
        };

        Cli pico = new Cli();
        CommandLine cli = new CommandLine(pico);

        StringWriter sw = new StringWriter();
        cli.setOut(new PrintWriter(sw));

        int exitCode = cli.execute(args);
        assertEquals(0, exitCode);
        assertTrue(sw.toString().contains("WELCOME TO GRAMI"));
    }
}
