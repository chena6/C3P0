package main;

public class Beer {
	
	private String name;
	
	private String type;
		/* ALE
		 * LAGER
		 * COOLERS
		 * SPECIALTY
		 * GIFT AND SAMPLER PACKS
		 * MALT BEVERAGES
		 * HYBRID
		 */
	
	private String style;
		/* LIGHT & MALTY
		 * LIGHT & FLORAL
		 * LIGHT & FRUITY
		 * MEDIUM & MALTY
		 * MEDIUM & HOPPY
		 * MEDIUM & ROASTED
		 * FULL & ROASTED
		 * FULL & HOPPY
		 * BOLD & SPICY  
		 */
	
	private String origin;
		/* 
		 * 
		 * TODO(terin): Find list of origins
		 * 
		 */

	public Beer(String n, String t, String s, String o) {
		this.setName(n);
		this.setType(t);
		this.setStyle(s);
		this.setOrigin(o);
	}

	public String name() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String type() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String style() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String origin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public boolean equals(Beer b) {
		return ( this.name.equals(b.name())
			   & this.type.equals(b.type())
			   & this.style.equals(b.style())
			   & this.origin.equals(b.origin()));
	}
	
	public String toString() {
		return name + "," + type  + "," + style  + "," + origin;
	}
}
