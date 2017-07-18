package main.com.vorh.test;

/**
 * Created by vorh on 7/18/17.
 */
public enum Operation {
    SUM("+"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    SUBTRACTION("-");

    private String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation getEnum(String value){
        for (Operation operation : values()) {
            if (operation.getValue().equals(value)){
                return operation;
            }
        }
        throw  new IllegalArgumentException("Enum not found");
    }

}
