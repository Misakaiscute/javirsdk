package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CameraGroup {
		@JsonProperty("Cameras")
		private Camera[] cameras = null;
		public Camera[] getCameras() { return cameras; }
		@JsonProperty("GroupNum")
		private int groupNum = 0;
		public int getGroupNum() { return groupNum; }
		@JsonProperty("GroupName")
		private String groupName = null;
		public String getGroupName() { return groupName; }
		@JsonProperty("IsScenic")
		private boolean isScenic = false;
		public boolean getIsScenic() { return isScenic; }
		//$...    
}
