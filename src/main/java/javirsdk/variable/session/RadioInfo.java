package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RadioInfo {
    @JsonProperty("SelectedRadioNum")
		private int selectedRadioNum = 0;
		public int getSelectedRadioNum() { return selectedRadioNum; }
		@JsonProperty("Radios")
		private Radio[] radios = null;
		public Radio[] getRadios() { return radios; }
		//$...    
}
