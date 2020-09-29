package org.postgresql.pgsql.karaf.ci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
class PostgresqlKarafFeatureTest {

    @Test
    void testLoadFeature() throws Exception {
    }

}
