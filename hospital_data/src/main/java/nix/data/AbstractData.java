package nix.data;

public abstract class AbstractData<T> {
    private Long id;

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}