/*
 * Created on Dec 22, 2010
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.error.ShouldMatchPattern.shouldMatch;
import static org.fest.assertions.test.ErrorMessages.regexPatternIsNull;
import static org.fest.assertions.test.FailureMessages.actualIsNull;
import static org.fest.assertions.test.TestData.*;
import static org.fest.assertions.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;

import static org.mockito.Mockito.verify;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

import org.fest.assertions.core.AssertionInfo;

/**
 * Tests for <code>{@link Strings#assertMatches(AssertionInfo, String, String)}</code>.
 * 
 * @author Alex Ruiz
 * @author Joel Costigliola
 */
public class Strings_assertMatches_String_Test extends AbstractTest_for_Strings {

  private String actual = "Yoda";

  @Test
  public void should_throw_error_if_regular_expression_is_null() {
    thrown.expectNullPointerException(regexPatternIsNull());
    String regex = null;
    strings.assertMatches(someInfo(), actual, regex);
  }

  @Test
  public void should_throw_error_if_syntax_of_regular_expression_is_invalid() {
    thrown.expect(PatternSyntaxException.class);
    strings.assertMatches(someInfo(), actual, "*...");
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    strings.assertMatches(someInfo(), null, matchAnything().pattern());
  }

  @Test
  public void should_fail_if_actual_does_not_match_regular_expression() {
    AssertionInfo info = someInfo();
    try {
      strings.assertMatches(info, actual, "Luke");
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldMatch(actual, "Luke"));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_pass_if_actual_matches_Pattern() {
    strings.assertMatches(someInfo(), actual, "Yod.*");
  }

  @Test
  public void should_throw_error_if_regular_expression_is_null_whatever_custom_comparison_strategy_is() {
    thrown.expectNullPointerException(regexPatternIsNull());
    String regex = null;
    stringsWithCaseInsensitiveComparisonStrategy.assertMatches(someInfo(), actual, regex);
  }

  @Test
  public void should_throw_error_if_syntax_of_regular_expression_is_invalid_whatever_custom_comparison_strategy_is() {
    thrown.expect(PatternSyntaxException.class);
    stringsWithCaseInsensitiveComparisonStrategy.assertMatches(someInfo(), actual, "*...");
  }

  @Test
  public void should_fail_if_actual_is_null_whatever_custom_comparison_strategy_is() {
    thrown.expectAssertionError(actualIsNull());
    stringsWithCaseInsensitiveComparisonStrategy.assertMatches(someInfo(), null, matchAnything().pattern());
  }

  @Test
  public void should_fail_if_actual_does_not_match_regular_expression_whatever_custom_comparison_strategy_is() {
    AssertionInfo info = someInfo();
    try {
      stringsWithCaseInsensitiveComparisonStrategy.assertMatches(info, actual, "Luke");
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldMatch(actual, "Luke"));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_pass_if_actual_matches_Pattern_whatever_custom_comparison_strategy_is() {
    stringsWithCaseInsensitiveComparisonStrategy.assertMatches(someInfo(), actual, "Yod.*");
  }
}
