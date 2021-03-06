/*
 * Created on May 28, 2012
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
 * Copyright @2010-2012 the original author or authors.
 */
package org.fest.assertions.api;

import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.fest.assertions.internal.Longs;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for <code>{@link LongAssert#isNotNegative()}</code>.
 * 
 * @author Nicolas François
 */
public class LongAssert_isNotNegative_Test {

  private Longs longs;
  private LongAssert assertions;

  @Before
  public void setUp() {
    longs = mock(Longs.class);
    assertions = new LongAssert(6L);
    assertions.longs = longs;
  }

  @Test
  public void should_verify_that_actual_is_not_negative() {
    assertions.isNotNegative();
    verify(longs).assertIsNotNegative(assertions.info, assertions.actual);
  }

  @Test
  public void should_return_this() {
    LongAssert returned = assertions.isNotNegative();
    assertSame(assertions, returned);
  }
}
