package com.kipuig.eventreminder.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class LayerRulesTest {

    private final JavaClasses importedClasses = new ClassFileImporter()
            .importPackages("com.kipuig.eventreminder");

    @Test
    void domain_should_not_depend_on_other_layers() {
        var rule = noClasses()
                .that().resideInAPackage("..eventreminder.domain..")
                .should().accessClassesThat()
                .resideInAnyPackage(
                        "..eventreminder.presentation..",
                        "..eventreminder.application..",
                        "..eventreminder.infrastructure..");

        rule.check(importedClasses);
    }

    @Test
    void application_should_not_depend_on_infrastructure_nor_presentation() {
        var rule = noClasses()
                .that().resideInAPackage("..eventreminder.application..")
                .should().accessClassesThat()
                .resideInAnyPackage(
                        "..eventreminder.presentation..",
                        "..eventreminder.infrastructure..");

        rule.check(importedClasses);
    }

    @Test
    void infra_should_not_depend_on_presentation() {
        var rule = noClasses()
                .that().resideInAPackage("..eventreminder.infrastructure..")
                .should().accessClassesThat()
                .resideInAPackage("..eventreminder.presentation..");

        rule.check(importedClasses);
    }

    @Test
    void presentation_should_not_depend_on_domain_nor_infra() {
        var rule = noClasses()
                .that().resideInAPackage("..eventreminder.presentation..")
                .should().accessClassesThat()
                .resideInAnyPackage(
                        "..eventreminder.domain..",
                        "..eventreminder.infrastructure..");

        rule.check(importedClasses);
    }
}
