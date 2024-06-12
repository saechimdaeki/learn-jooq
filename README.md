# learn-jooq


### JOOQ를 쓴다면
- 문법 오류를 컴파일 타임에 체크
- 스키마 구조를 컴파일 타임에 체크
- 모든 RDBMS의 기능들을 TypeSafe하게 사용
- XML작업? 그게 뭐죠

`맛보기`

```java
@SpringBootTest
public void PreviewTest{
    @Autowired
    private DSLContext dsl;

    @Test
    void test() {
        Actor_ ACTOR = Actor_.ACTOR;

        // Condition lastNameLike = ACTOR.LAST_NAME.like("%ss%")

        List<Actor> actors = dsl.selectFrom(ACTOR)
            .where(
                likeIfNotEmpty(ACTOR.LAST_NAME, "%ss%")
            )
            .fetchInto(Actor.class);
    }

    private Condition likeIfNotEmpty (TableField<? extends Record, String> tableField, String param) {
        if (StringUtils.isEmpty(param))
            return DSL.noCondition();
        return tableField.like("%"+param+"%");
    }
}
```

---

자주 사용되는 generate 옵션들

|               |           |                                                                                                           |
|---------------|-----------|-----------------------------------------------------------------------------------------------------------|
| `옵션명`         | `default` |                                                                                                           |
| fluentSetter  | false     | pojo나 record생성시 return값이 void가 대신 객체 자체를 리턴                                                               |
| javaTimeTypes | false     | java.sql.Date, java.sql.Time, java.sql.Timestamp대신 <br/> java.time의 LocalDate, LocalTime, LocalDateTime리턴 |
| unsignedTypes | true      | jOOQ에서 제공하는 unsigned type 사용 여부 (미사용 추천, database)                                                        |
| forcedTypes   | -         | 특정 데이터 타입을 DSL에선 강제로 다른타입으로 지정 (eg. INET, JSON을 -> varchar로)                                              |
| daos          | false     | DSL생성시 일부 편의 기능이 완성되어 있는 Dao자동생성                                                                          |
| pojos         | false     | DB테이블에 대응되는 pojo 자동생성                                                                                     |
| record        | false     | DB테이블에 대응되는 ActiveRecord자동생성                                                                              |
