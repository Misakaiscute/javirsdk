package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CameraInfo {
    @JsonProperty("Groups")
    private CameraGroup[] cameraGroups = null;
    public CameraGroup[] getCameraGroups() { return this.cameraGroups; }
    //$...
}
