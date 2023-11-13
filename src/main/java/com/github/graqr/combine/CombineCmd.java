package com.github.graqr.combine;


import com.github.graqr.combine.model.TcinList;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;

@CommandLine.Command(name = "combine",
        description = "pulls current pricing from target's api",
        mixinStandardHelpOptions = true,
        versionProvider = CombineCmd.ManifestVersionProvider.class,
        showDefaultValues = true)
public class CombineCmd implements Runnable {

    @Inject
    CombineController combineController;

    @CommandLine.Option(names = {"-t", "--tcins"}, converter = TcinsConverter.class)
    TcinList tcins;

    @CommandLine.Option(names = {"--key", "--secret", "-p",})
    String key;

    public static void main(String[] args) {
        PicocliRunner.run(CombineCmd.class, args);
    }

    public void run() {
    }

    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        @Override
        public String[] getVersion() {
            return new String[]{
                    CombineCmd.class.getPackage().getImplementationVersion()
            };
        }
    }

    static class TcinsConverter implements CommandLine.ITypeConverter<TcinList> {
        @Override
        public TcinList convert(String s) {
            return new TcinList(Arrays.stream(s.split(",")).mapToLong(Long::parseLong).toArray());
        }
    }
}
