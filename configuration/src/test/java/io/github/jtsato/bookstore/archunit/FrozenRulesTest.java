package io.github.jtsato.bookstore.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import io.github.jtsato.bookstore.BookstoreApplication;

/**
 * @author Jorge Takeshi Sato  
 */

@AnalyzeClasses(packagesOf = BookstoreApplication.class)
public class FrozenRulesTest {

    @ArchTest
    static final ArchRule no_classes_should_use_the_exception_handler = freeze(noClasses().should()
                                                                                          .dependOnClassesThat()
                                                                                          .areAssignableTo(BookstoreApplication.class));
}
