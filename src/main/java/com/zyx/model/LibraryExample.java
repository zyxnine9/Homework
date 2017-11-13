package com.zyx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LibraryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRecodIsNull() {
            addCriterion("recod is null");
            return (Criteria) this;
        }

        public Criteria andRecodIsNotNull() {
            addCriterion("recod is not null");
            return (Criteria) this;
        }

        public Criteria andRecodEqualTo(Integer value) {
            addCriterion("recod =", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodNotEqualTo(Integer value) {
            addCriterion("recod <>", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodGreaterThan(Integer value) {
            addCriterion("recod >", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodGreaterThanOrEqualTo(Integer value) {
            addCriterion("recod >=", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodLessThan(Integer value) {
            addCriterion("recod <", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodLessThanOrEqualTo(Integer value) {
            addCriterion("recod <=", value, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodIn(List<Integer> values) {
            addCriterion("recod in", values, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodNotIn(List<Integer> values) {
            addCriterion("recod not in", values, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodBetween(Integer value1, Integer value2) {
            addCriterion("recod between", value1, value2, "recod");
            return (Criteria) this;
        }

        public Criteria andRecodNotBetween(Integer value1, Integer value2) {
            addCriterion("recod not between", value1, value2, "recod");
            return (Criteria) this;
        }

        public Criteria andBtimeIsNull() {
            addCriterion("btime is null");
            return (Criteria) this;
        }

        public Criteria andBtimeIsNotNull() {
            addCriterion("btime is not null");
            return (Criteria) this;
        }

        public Criteria andBtimeEqualTo(Date value) {
            addCriterionForJDBCDate("btime =", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("btime <>", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("btime >", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("btime >=", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeLessThan(Date value) {
            addCriterionForJDBCDate("btime <", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("btime <=", value, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeIn(List<Date> values) {
            addCriterionForJDBCDate("btime in", values, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("btime not in", values, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("btime between", value1, value2, "btime");
            return (Criteria) this;
        }

        public Criteria andBtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("btime not between", value1, value2, "btime");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNull() {
            addCriterion("rtime is null");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNotNull() {
            addCriterion("rtime is not null");
            return (Criteria) this;
        }

        public Criteria andRtimeEqualTo(Date value) {
            addCriterionForJDBCDate("rtime =", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("rtime <>", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("rtime >", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rtime >=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThan(Date value) {
            addCriterionForJDBCDate("rtime <", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rtime <=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeIn(List<Date> values) {
            addCriterionForJDBCDate("rtime in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("rtime not in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rtime between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rtime not between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andBdaysIsNull() {
            addCriterion("bdays is null");
            return (Criteria) this;
        }

        public Criteria andBdaysIsNotNull() {
            addCriterion("bdays is not null");
            return (Criteria) this;
        }

        public Criteria andBdaysEqualTo(Integer value) {
            addCriterion("bdays =", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysNotEqualTo(Integer value) {
            addCriterion("bdays <>", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysGreaterThan(Integer value) {
            addCriterion("bdays >", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("bdays >=", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysLessThan(Integer value) {
            addCriterion("bdays <", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysLessThanOrEqualTo(Integer value) {
            addCriterion("bdays <=", value, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysIn(List<Integer> values) {
            addCriterion("bdays in", values, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysNotIn(List<Integer> values) {
            addCriterion("bdays not in", values, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysBetween(Integer value1, Integer value2) {
            addCriterion("bdays between", value1, value2, "bdays");
            return (Criteria) this;
        }

        public Criteria andBdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("bdays not between", value1, value2, "bdays");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNull() {
            addCriterion("reader_id is null");
            return (Criteria) this;
        }

        public Criteria andReaderIdIsNotNull() {
            addCriterion("reader_id is not null");
            return (Criteria) this;
        }

        public Criteria andReaderIdEqualTo(Integer value) {
            addCriterion("reader_id =", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotEqualTo(Integer value) {
            addCriterion("reader_id <>", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThan(Integer value) {
            addCriterion("reader_id >", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reader_id >=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThan(Integer value) {
            addCriterion("reader_id <", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdLessThanOrEqualTo(Integer value) {
            addCriterion("reader_id <=", value, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdIn(List<Integer> values) {
            addCriterion("reader_id in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotIn(List<Integer> values) {
            addCriterion("reader_id not in", values, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdBetween(Integer value1, Integer value2) {
            addCriterion("reader_id between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andReaderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reader_id not between", value1, value2, "readerId");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(String value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(String value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(String value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(String value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(String value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLike(String value) {
            addCriterion("book_id like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotLike(String value) {
            addCriterion("book_id not like", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<String> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<String> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(String value1, String value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(String value1, String value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}