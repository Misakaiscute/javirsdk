package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

public class Camera {
    @JsonProperty("CameraNum")
		private int cameraNum = 0;
		public int getCameraNum() { return cameraNum; }
		@JsonProperty("CameraName")
		private String cameraName = null;
		public String getCameraName() { return cameraName; }
		//$...    
}
