# Java Fluent Validator

Java Fluent Validator is inspired by Fluent Interface and .Net FluentValidation which defined an inner-DSL within Java language for programmers to use. A fluent interface implies that its primary goal is to make it easy to SPEAK and UNDERSTAND.

##### This simple project was based on [Java Fluent Validator by @mvallim](https://github.com/mvallim/java-fluent-validator)

## Sample

```java
public class ParentValidator extends AbstractValidator<Parent> {
    @Override
    public void rules() {
        setPropertyOnContext(Parent.class.getName());

        ruleFor(Parent::getName)
                .must(not(stringEmptyOrNull()))
                .withFieldName("name")
                .withMessage("Parent name cannot be null or empty")
                .critical();
    }
}
```

## Sample validation checking duplicated id's
````java
public class ParentValidator extends AbstractValidator<Parent> {

    @Override
    public void rules() {
        // ....

        ruleFor(parent -> hasDuplicateChildrenId(parent.getChildren()))
                .whenever(not(nullValue()))
                .withValidator(new ChildrenDuplicatedValidator())
                .critical();
    }

    private Boolean hasDuplicateChildrenId(Collection<Child> children) {
        List<UUID> uuids = children.stream()
                .map(Child::getId)
                .collect(Collectors.toList());

        Set<UUID> totalUuids = uuids.stream()
                .filter(i -> Collections.frequency(uuids, i) > 1)
                .collect(Collectors.toSet());

        return totalUuids.size() > 0;
    }
}

public class ChildrenDuplicatedValidator extends AbstractValidator<Boolean> {

    @Override
    public void rules() {
        ruleFor(Boolean::booleanValue)
                .must(isFalse())
                .withFieldName("children.id")
                .withMessage("Child id cannot be duplicated")
                .critical();
    }
}
````

### Endpoint to test
````
POST localhost:8080/new

{
    "name": "Leonardo",
    "age": 27,
    "cities": [
        "Campinas"
    ],
    "children": [
        {
            "id": "ed40ef7f-bef4-448f-b660-f588651e88d1",
            "name": "Livia",
            "age": 3
        },
        {
            "id": "ed40ef7f-bef4-448f-b660-f588651e88d1", // same id
            "name": "Bernardo",
            "age": 4
        }
    ]
}
````
