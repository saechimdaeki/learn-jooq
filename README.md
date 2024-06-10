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