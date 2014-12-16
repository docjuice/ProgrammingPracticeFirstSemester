public class Edge{
	int v1, v2;

	public Edge(int v1, int v2){
		if (v1 <= v2){
			this.v1 = v1;
			this.v2 = v2;
		} else{
			this.v1 = v2;
			this.v2 = v1;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Edge edge = (Edge) o;

		if (v1 != edge.v1) return false;
		if (v2 != edge.v2) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = v1;
		result = 31 * result + v2;
		return result;
	}
}
