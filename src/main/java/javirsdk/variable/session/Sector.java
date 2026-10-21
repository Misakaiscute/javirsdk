package javirsdk.variable.session;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sector {
   	@JsonProperty("SectorNum")
		private int sectorNum = 0;
		public int getSectorNum() { return sectorNum; }
		@JsonProperty("SectorStartPct")
		private double sectorStartPct = 0.0;
		public double getSectorStartPct() { return sectorStartPct; }
		//$...    
}
