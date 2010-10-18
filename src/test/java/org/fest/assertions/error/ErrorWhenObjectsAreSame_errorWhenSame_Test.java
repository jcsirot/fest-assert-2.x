/*
 * Created on Sep 17, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.error;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Tests for <code>{@link ErrorWhenObjectsAreSame#errorWhenSame(Object)}</code>.
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ErrorWhenObjectsAreSame_errorWhenSame_Test {

  private static Object a;

  @BeforeClass public static void setUpOnce() {
    a = new Object();
  }

  @Test public void should_create_new_AssertionErrorFactory() {
    AssertionErrorFactory factory = ErrorWhenObjectsAreSame.errorWhenSame(a);
    assertEquals(ErrorWhenObjectsAreSame.class, factory.getClass());
  }

  @Test public void should_pass_actual() {
    ErrorWhenObjectsAreSame factory = (ErrorWhenObjectsAreSame) ErrorWhenObjectsAreSame.errorWhenSame(a);
    assertSame(a, factory.actual);
  }
}