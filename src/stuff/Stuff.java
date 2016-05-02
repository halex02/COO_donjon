package stuff;

public class Stuff {
	protected String name;
	private String description;
	private Integer weight;
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getValue() {
		return value;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && name != null){
			return name.equals(((Stuff) obj).name);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode() * 12;
	}
}
