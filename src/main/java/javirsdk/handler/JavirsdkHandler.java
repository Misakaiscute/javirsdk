package javirsdk.handler;

public interface JavirsdkHandler<T> {
    public String getId();
    public void execute();
    public void reset();
}
