package io.github.jtsato.bookstore.archunit;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import io.github.jtsato.bookstore.BookstoreApplication;

/**
 * @author Jorge Takeshi Sato
 */

@AnalyzeClasses(packagesOf = BookstoreApplication.class)
public class LayeredArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

                                                                                  .layer("Configurations")
                                                                                  .definedBy("..configuration..")
                                                                                  .layer("Controllers")
                                                                                  .definedBy("..controller..")
                                                                                  .layer("UseCases")
                                                                                  .definedBy("..usecase..")
                                                                                  .layer("Gateways")
                                                                                  .definedBy("..gateway..")
                                                                                  .layer("DataProviders")
                                                                                  .definedBy("..dataprovider..")
                                                                                  .whereLayer("Controllers")
                                                                                  .mayNotBeAccessedByAnyLayer()
                                                                                  .whereLayer("UseCases")
                                                                                  .mayOnlyBeAccessedByLayers("Controllers", "Gateways", "DataProviders")
                                                                                  .whereLayer("Gateways")
                                                                                  .mayOnlyBeAccessedByLayers("UseCases", "DataProviders")
                                                                                  .whereLayer("DataProviders")
                                                                                  .mayOnlyBeAccessedByLayers("Gateways");
}
