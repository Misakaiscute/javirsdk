package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SplitTimeInfo {
    @JsonProperty("Sectors")
    private Sector[] sectors = null;
    public Sector[] getSectors() { return sectors; }
}
