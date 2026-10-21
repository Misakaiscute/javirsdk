package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionInfo {
    @JsonProperty("Sessions")
		private Session[] sessions = null;
		public Session[] getSessions() { return sessions; }
		//$...    
}
