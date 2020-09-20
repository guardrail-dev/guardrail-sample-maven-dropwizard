package helloworld;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

public class EqualsContractTest {

    @Test
    public void testEqualsContract() {
        try (ScanResult scanResult =
                     new ClassGraph()
                             .enableClassInfo()
                             .enableMethodInfo()
                             .acceptPackages("com.example.clients.petstore.definitions")
                             .scan()) {

            assertThat(scanResult.getAllClasses().size()).isGreaterThan(0);
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                final boolean isBuilder = classInfo.getName().endsWith("Builder");
                if (!isBuilder) {
                  verify(classInfo.loadClass());
                }
            }
        }
    }

    private static void verify(final Class clazz) {
        EqualsVerifier.forClass(clazz)
                .usingGetClass()
                .verify();
    }
}
