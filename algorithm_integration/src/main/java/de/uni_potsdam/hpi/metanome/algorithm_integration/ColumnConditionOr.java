package de.uni_potsdam.hpi.metanome.algorithm_integration;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Jens Hildebrandt
 */
public class ColumnConditionOr implements ColumnCondition {
  TreeSet<ColumnCondition> columnValues;

  /**
   * Exists for Gwt serialization
   */
  protected ColumnConditionOr() {
    this.columnValues = new TreeSet<>();
  }

  public ColumnConditionOr(Map<ColumnIdentifier, String> conditionMap) {
    this();
    for (ColumnIdentifier column : conditionMap.keySet()) {

      columnValues.add(new ConditionValue(column, conditionMap.get(column)));
    }
  }
  public ColumnConditionOr(TreeSet<ColumnCondition> treeSet) {
    this.columnValues = new TreeSet<>(treeSet);
  }

  public ColumnConditionOr(ColumnCondition... conditions) {
    this();
    for (ColumnCondition condition : conditions) {
      this.columnValues.add(condition);
    }
  }
  @Override
  public void add(ColumnCondition condition) {
    this.columnValues.add(condition);
  }

  public TreeSet<ColumnCondition> getColumnValues() {
    return columnValues;
  }
  @Override
  public int compareTo(ColumnCondition o) {
    if (o instanceof ColumnConditionOr) {
      ColumnConditionOr other = (ColumnConditionOr) o;
      int lengthComparison = this.columnValues.size() - other.columnValues.size();
      if (lengthComparison != 0) {
        return lengthComparison;
      } else {
        Iterator<ColumnCondition> thisIterator = this.columnValues.iterator();
        Iterator<ColumnCondition> otherIterator = other.columnValues.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
          ColumnCondition currentThis = thisIterator.next();
          ColumnCondition currentOther = otherIterator.next();

          int currentComparison = currentThis.compareTo(currentOther);
          if (currentComparison != 0) {
            return currentComparison;
          }
        }
        //must be equal
        return 0;
      }
    } else {
      //or between "simple" and "and"
      if (o instanceof ConditionValue) {
        return 1;
      } else {
        return -1;
      }
    }
  }

  @Override
  public String toString() {
    String delimiter = " " + ColumnCondition.OR + " ";
    StringBuilder builder = new StringBuilder();
    builder.append(ColumnCondition.OPEN_BRACKET);
    for (ColumnCondition value : this.columnValues) {
      builder.append(value.toString());
      builder.append(delimiter);
    }
    return builder.substring(0, builder.length() - delimiter.length()).concat(ColumnCondition.CLOSE_BRACKET);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ColumnConditionOr that = (ColumnConditionOr) o;

    if (columnValues != null ? !columnValues.equals(that.columnValues)
                             : that.columnValues != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return columnValues != null ? columnValues.hashCode() : 0;
  }
}
