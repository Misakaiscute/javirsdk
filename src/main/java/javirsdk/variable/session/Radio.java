package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Radio {
   	@JsonProperty("RadioNum")
		private int radioNum = 0;
		public int getRadioNum() { return radioNum; }
		@JsonProperty("HopCount")
		private int hopCount = 0;
		public int getHopCount() { return hopCount; }
		@JsonProperty("NumFrequencies")
		private int numFrequencies = 0;
		public int getNumFrequencies() { return numFrequencies; }
		@JsonProperty("TunedToFrequencyNum")
		private int tunedToFrequencyNum = 0;
		public int getTunedToFrequencyNum() { return tunedToFrequencyNum; }
		@JsonProperty("ScanningIsOn")
		private byte scanningIsOn = 0;
		public boolean getScanningIsOn() { return scanningIsOn == 1; }
		@JsonProperty("Frequencies")
		private Frequency[] frequency = null;
		public Frequency[] getFrequency() { return frequency; }
		//$...    
}
