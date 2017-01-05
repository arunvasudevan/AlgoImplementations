package src.com.datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class routeBetweenNodes {

	public boolean search(GraphNode n1, GraphNode n2) {
		if (n1 == n2)
			return true;
		final Queue<GraphNode> q = new LinkedList<>();
		q.add(n1);
		n1.setVisitedFlag(true);
		GraphNode n;
		while (!q.isEmpty()) {
			n = q.remove();
			for (final GraphNode t : n.adjacencyList) {
				if (t == n2)
					return true;
				if (!t.getVisitedFlag()) {
					q.add(t);
					t.setVisitedFlag(false);
				}
			}

		}
		return false;
	}

}
