package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class TelemetryOptions {
   	@JsonProperty("TelemetryDiskFile")
		private String telemetryDiskFile = null;
		public String getTelemetryDiskFile() { return telemetryDiskFile; }
		//$...    
}
