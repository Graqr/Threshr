package com.github.graqr.threshr;


import com.github.graqr.threshr.model.Tcin;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "threshr",
        description = "pulls current pricing from target's api",
        mixinStandardHelpOptions = true,
        versionProvider = ThreshrCmd.ManifestVersionProvider.class,
        showDefaultValues = true)
public class ThreshrCmd implements Runnable {

    @Inject
    ThreshrController threshrController;

    @CommandLine.Option(names = {"-t", "--tcins"}, converter = TcinsConverter.class)
    Tcin tcins;

    @CommandLine.Option(names = {"--key", "--secret", "-p",})
    String key;

    public static void main(String[] args) {
        PicocliRunner.run(ThreshrCmd.class, args);
    }

    public void run() {
    }

    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        @Override
        public String[] getVersion() {
            return new String[]{
                    ThreshrCmd.class.getPackage().getImplementationVersion()
            };
        }
    }

    static class TcinsConverter implements CommandLine.ITypeConverter<Tcin> {
        @Override
        public Tcin convert(String passedArgs) {
            return new Tcin(passedArgs.split(","));
        }
    }
}
