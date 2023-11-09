package com.github.peanutbutter.unicorn.tarvester;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.github.peanutbutter.unicorn.tarvester.model.TargetStore;
import com.github.peanutbutter.unicorn.tarvester.model.TcinList;
import com.github.peanutbutter.unicorn.tarvester.model.products.ProductSummary;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.Arrays;

@CommandLine.Command(name = "tarvester",
        description = "pulls current pricing from target's api",
        mixinStandardHelpOptions = true,
        versionProvider = TarvesterCmd.ManifestVersionProvider.class,
        showDefaultValues = true)
public class TarvesterCmd implements Runnable {

    @Inject
    TarvesterController tarvesterController;

    @CommandLine.Option(names = {"-t", "--tcins"}, converter = TcinsConverter.class)
    TcinList tcins;

    @CommandLine.Option(names = {"--key", "--secret", "-p",})
    String key;

    public static void main(String[] args) {
        PicocliRunner.run(TarvesterCmd.class, args);
    }

    public void run() {
        TargetStore targetStore = new TargetStore(
                1750,
                "UT",
                "84014-1752",
                40.91825,
                -111.887
        );
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(ProductSummary.class);
    }

    public static class ManifestVersionProvider implements CommandLine.IVersionProvider {
        @Override
        public String[] getVersion() {
            return new String[]{
                    TarvesterCmd.class.getPackage().getImplementationVersion()
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
