package com.graqr;

import com.graqr.threshr.Threshr;
import com.graqr.threshr.ThreshrException;
import com.graqr.threshr.model.queryparam.Tcin;
import io.micronaut.configuration.picocli.PicocliRunner;
import jakarta.inject.Singleton;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Singleton
@Command(name = "threshr grocery query tool", mixinStandardHelpOptions = true)
public class ThreshrCli implements Runnable {

    Threshr threshr;

    @Option(
            names = {"--tcin", "-t", "product-id-number"},
            required = false,
            description = "", converter = TcinsConverter.class)
            Tcin[] tcinValues;

    public ThreshrCli(Threshr threshr) {
        this.threshr = threshr;
    }


    public static void main(String[] args) {
        PicocliRunner.run(ThreshrCli.class, args);
    }

    public void run() {
        // TODO: do all the things :P
    }

    static class TcinsConverter implements CommandLine.ITypeConverter<Tcin[]> {
        @Override
        public Tcin[] convert(String s) throws ThreshrException {
            return new Tcin[]{new Tcin(s.split(","))};
        }
    }
}