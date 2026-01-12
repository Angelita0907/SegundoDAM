package mongo.modelo;

public class Score {

	private Double score;
	private String type;
	
	

	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(Double score, String type) {
		super();
		this.score = score;
		this.type = type;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", type=" + type + "]";
	}

	
	
}
