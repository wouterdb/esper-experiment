package dnet.monitor.cep.model;

public class Alerts {
	
	public static Level rankLow(float val,Double soft,Double hard){
		if(val<soft)
			return Level.OK;
		if(val<hard)
			return Level.WARN;
		return Level.ALERT;
	}

}
