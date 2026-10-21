package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QualifyResultsInfo {
    @JsonProperty("Results")
    private QualiResult[] qualiResults = null;
    public QualiResult[] getQualiResults() { return this.qualiResults; }
    //$...
}
