package seed;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "seeds")
@XmlAccessorType(XmlAccessType.FIELD)
public class Seeds {
	@XmlElement(name = "seed",required = true)
	List<Seed> seeds;
	
	public List<Seed> getSeeds(){
		return this.seeds;
	}

    
    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }
    

    public void add(Seed seed) {
        if (this.seeds == null) {
            this.seeds = new ArrayList<Seed>();
        }
    }
}
