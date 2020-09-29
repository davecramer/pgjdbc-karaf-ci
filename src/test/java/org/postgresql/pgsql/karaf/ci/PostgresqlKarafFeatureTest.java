package org.postgresql.pgsql.karaf.ci;

import java.util.stream.Stream;

import org.apache.karaf.itests.KarafTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.ops4j.pax.exam.CoreOptions.*;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class PostgresqlKarafFeatureTest extends KarafTestSupport {

    @Configuration
    public Option[] config() {
        MavenArtifactUrlReference postgresqlFeatureRepo = maven().groupId("org.postgresql").artifactId("postgresql").versionAsInProject().type("xml").classifier("features");
        Option[] options = new Option[] {
                features(postgresqlFeatureRepo)
        };
        return Stream.of(super.config(), options).flatMap(Stream::of).toArray(Option[]::new);
    }

    @Test
    public void testLoadFeature() throws Exception {
        installAndAssertFeature("postgresql");
    }

}
