package xdx.note.framework.redis;

public enum RedisMode {

    SINGLE("SINGLE"),
    CLUSTER("CLUSTER"),
    SENTINEL("SENTINEL"),
    ;
    private String mode;

    RedisMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }


    public static RedisMode match(String mode) {
        RedisMode[] values = RedisMode.values();
        for (RedisMode value : values) {
            if (value.getMode().equals(mode)) {
                return value;
            }
        }
        return RedisMode.CLUSTER;
    }


}
