package com.github.peanutbutter.unicorn.tarvester.cmd;

import com.github.peanutbutter.unicorn.tarvester.util.EnvValidation;
import picocli.CommandLine;

import java.nio.file.Path;
import java.nio.file.Paths;

@CommandLine.Command(name = "tarvester",
        description = "pulls current pricing from target's api",
        mixinStandardHelpOptions = true,
        versionProvider = Tarvester.ManifestVersionProvider.class,
        showDefaultValues = true)
public class Tarvester implements Runnable {
    Path properties = Paths.get(".env");

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @CommandLine.Option(names = {"-v", "--verbose"})
    boolean verbose;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new Tarvester());
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }

    public void run() {
        EnvValidation.validateFile(spec, properties);
        System.out.println("hello there");
    }

    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        @Override
        public String[] getVersion() {
            return new String[]{Tarvester.class.getPackage().getImplementationVersion()};
        }
    }
}
