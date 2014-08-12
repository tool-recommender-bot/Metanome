/*
 * Copyright 2014 by the Metanome project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.uni_potsdam.hpi.metanome.algorithm_integration;

import de.uni_potsdam.hpi.metanome.test_helper.EqualsAndHashCodeTester;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link ColumnConditionAnd}
 *
 * @author Jens Hildebrandt
 */
public class ColumnConditionTest {


  /**
   * Test method for {@link ColumnConditionAnd#equals(Object)}
   * and {@link ColumnConditionAnd#hashCode()} <p/> {@link ColumnConditionAnd}
   * containing the same condition values for the same column should be equal
   */
/*
  @Test
  public void testEqualsHashCode() {
    //Setup
    ColumnIdentifier column11 = new ColumnIdentifier("table1", "column1");
    ColumnIdentifier column12 = new ColumnIdentifier("table2", "column2");

    ColumnIdentifier column21 = new ColumnIdentifier("table1", "column1");

    List<String> conditionValues1 = new LinkedList<>();
    conditionValues1.add("a");
    conditionValues1.add("b");

    List<String> conditionValues2 = new LinkedList<>();
    conditionValues2.add("b");
    conditionValues2.add("a");

    List<String> conditionValues3 = new LinkedList<>();
    conditionValues3.add("a");
    conditionValues3.add("b");
    conditionValues3.add("c");

    ColumnConditionAnd
        columnCondition1 =
        new ColumnConditionAnd(column11, conditionValues1);
    ColumnConditionAnd
        columnConditionEq =
        new ColumnConditionAnd(column21, conditionValues1);
    ColumnConditionAnd
        columnConditionEq2 =
        new ColumnConditionAnd(column11, conditionValues2);

    ColumnConditionAnd
        columnConditionNotEq =
        new ColumnConditionAnd(column12, conditionValues1);
    ColumnConditionAnd
        columnConditionNotEq2 =
        new ColumnConditionAnd(column11, conditionValues3);

    EqualsAndHashCodeTester<ColumnConditionAnd> tester = new EqualsAndHashCodeTester<>();

    //Execute functionality
    //Check Result
    tester.performBasicEqualsAndHashCodeChecks(columnCondition1, columnConditionEq,
                                               columnConditionNotEq, columnConditionNotEq2);
    tester.performBasicEqualsAndHashCodeChecks(columnCondition1, columnConditionEq2);
  }

*/

  /**
   * Test method for {@link ColumnConditionAnd#toString()}
   */
  @Test
  public void testToString() {
    //Setup
    ColumnIdentifier column11 = new ColumnIdentifier("table1", "column1");
    ColumnIdentifier column12 = new ColumnIdentifier("table1", "column2");
    ColumnIdentifier column21 = new ColumnIdentifier("table2", "column1");

    ColumnCondition andCondition = new ColumnConditionAnd(new ConditionValue(column11, "A"), new ConditionValue(column12, "B"));
    ColumnCondition OrCondition = new ColumnConditionOr(andCondition, new ConditionValue(column21, "A"));
    //check result
    assertEquals("[table2.column1: A | [table1.column1: A & table1.column2: B]]", OrCondition.toString());
  }
}
