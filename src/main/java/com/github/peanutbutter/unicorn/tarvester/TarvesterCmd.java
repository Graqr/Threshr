package com.github.peanutbutter.unicorn.tarvester;

import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;

@CommandLine.Command(name = "tarvester",
        description = "pulls current pricing from target's api",
        mixinStandardHelpOptions = true,
        versionProvider = TarvesterCmd.ManifestVersionProvider.class,
        showDefaultValues = true)
public class TarvesterCmd implements Runnable {

    @Inject
    TarvesterClient tarvesterClient;

    @CommandLine.Option(names = {"-t", "--tcins"}, split = ",") // https://picocli.info/#_split_regex
    public long[] tcins;

    public static void main(String[] args) {
        PicocliRunner.run(TarvesterCmd.class, args);
    }

    public void run() {
        validateTCIN();
        TargetStore targetStore = new TargetStore(
                "1750",
                "Centerville",
                "STORE",
                "200 N Market Place Dr",
                "Centerville",
                "UT",
                "84014-1752",
                "40.91825",
                "-111.887",
                "true",
                false,
                "8012920071",
                "false"
        );
        System.out.println(tarvesterClient.fetchProducts(targetStore.toString(), "&tcins="
                + Arrays.stream(tcins)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("%2C"))).body());
    }


    public void validateTCIN() {
        LongPredicate tcin = t -> !String.valueOf(t).matches("\\d{8}");
        String badTcin = Arrays.stream(tcins)
                .filter(tcin)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        if (!badTcin.isEmpty()) {
            throw new CommandLine.PicocliException("the following are invalid tcin:" + badTcin);
        }
    }

    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        @Override
        public String[] getVersion() {
            return new String[]{
                    TarvesterCmd.class.getPackage().getImplementationVersion()
            };
        }
    }
}
