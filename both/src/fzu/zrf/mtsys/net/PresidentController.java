package fzu.zrf.mtsys.net;

import java.io.Serializable;
import java.util.Arrays;

import fzu.zrf.mtsys.net.Login.Result;
import fzu.zrf.mtsys.net.Login.Result.Type;

public class PresidentController implements Serializable {
	//Login login=null;
	Result result=null;
	Type type;
	String name;
	int[] forms;
	public PresidentController(Result rs) {
		this.result=rs;
		type=rs.type;
		this.name=rs.name;
		this.forms=rs.forms;
	}
	
	public String getName() {
        return name;
    }
	
	public Type getType() {
        return type;
    }
	
	public int[] getForm() {
		return forms;
	}
	public String toString() {
        return "Result [type=" + type + ", name=" + name + ", forms=" + Arrays.toString(forms) + "]";
    }		
}
